package com.mmako.spring.service;
import com.mmako.spring.exception.ServiceCallException;
import com.mmako.spring.service.api.CovidStatsApi;
import com.mmako.spring.service.models.covidstats.provinces.Provinces;
import com.mmako.spring.service.models.covidstats.provinces.ProvincesResponse;
import com.mmako.spring.service.models.covidstats.regions.Region;
import com.mmako.spring.service.models.covidstats.regions.RegionResponse;
import org.springframework.cache.annotation.Cacheable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServiceStatisticsImplementation implements ServiceStatistics {

    private final CovidStatsApi covidStatsApi;

    public ServiceStatisticsImplementation(Retrofit retrofit) {
        this.covidStatsApi = retrofit.create(CovidStatsApi.class);
    }

    @Override
    @Cacheable(value = "regions-cache", key = "#page + '-' + #size")
    public List<Region> getRegions(int page, int size) {
        Call<RegionResponse> call = covidStatsApi.getRegions(page, size);
        try {
            Response<RegionResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                List<Region> regions = getRegionList(response);

                int startIndex = (page - 1) * size;
                int endIndex = Math.min(startIndex + size, regions.size());

                if (startIndex >= regions.size()) {
                    return new ArrayList<>();
                }

                return regions.subList(startIndex, endIndex);
            } else {
                throw new ServiceCallException("Failed to get regions data from regions api with status code: " + response.code());
            }
        } catch (IOException exception) {
            throw new ServiceCallException("Regions API call failure", exception);
        }
    }

    @Override
    @Cacheable(value = "provinces-cache", key = "#iso + '-' + #page + '-' + #size + '-' + #provinceNameFilter")
    public List<Provinces> getProvinces(String iso, int page, int size, String provinceNameFilter) {
        Call<ProvincesResponse> call = covidStatsApi.getProvinces(iso, page, size, provinceNameFilter);
        try {
            Response<ProvincesResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                List<Provinces> provinces = getProvincesList(response);

                if (provinceNameFilter != null && !provinceNameFilter.isEmpty()) {
                    provinces = filterByProvinceName(provinces, provinceNameFilter);
                }

                int startIndex = (page - 1) * size;
                int endIndex = Math.min(startIndex + size, provinces.size());

                if (startIndex >= provinces.size()) {
                    return new ArrayList<>();
                }

                return provinces.subList(startIndex, endIndex);
            } else {
                throw new ServiceCallException("Failed to get provinces data from provinces api with status code: " + response.code());
            }
        } catch (IOException exception) {
            throw new ServiceCallException("Provinces API call failure", exception);
        }
    }

    private List<Provinces> filterByProvinceName(List<Provinces> provinces, String provinceNameFilter) {
        List<Provinces> filteredList = new ArrayList<>();
        for (Provinces province : provinces) {
            if (province.getProvince().toLowerCase().contains(provinceNameFilter.toLowerCase())) {
                filteredList.add(province);
            }
        }
        return filteredList;
    }

    private List<Region> getRegionList(Response<RegionResponse> response) {
        RegionResponse regionResponse = response.body();
        return regionResponse.getRegionData();
    }

    private List<Provinces> getProvincesList(Response<ProvincesResponse> response) {
        ProvincesResponse provincesResponse = response.body();
        return provincesResponse.getProvincesData();
    }
}