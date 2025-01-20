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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class ServiceStatisticsImplementation implements ServiceStatistics {

    private final CovidStatsApi covidStatsApi;
    private final Executor apiExecutor;

    // Constructor to inject Retrofit and custom executor
    public ServiceStatisticsImplementation(Retrofit retrofit, Executor apiExecutor) {
        this.covidStatsApi = retrofit.create(CovidStatsApi.class);
        this.apiExecutor = apiExecutor;
    }

    @Override
    @Cacheable(value = "regions-cache", key = "#page + '-' + #size")
    public CompletableFuture<List<Region>> getRegions(int page, int size) {
        return CompletableFuture.supplyAsync(() -> {
            Call<RegionResponse> call = covidStatsApi.getRegions(page, size);
            return handleRegionResponse(call, page, size);
        }, apiExecutor);
    }

    @Override
    @Cacheable(value = "provinces-cache", key = "#iso + '-' + #page + '-' + #size + '-' + #provinceNameFilter")
    public CompletableFuture<List<Provinces>> getProvinces(String iso, int page, int size, String provinceNameFilter) {
        return CompletableFuture.supplyAsync(() -> {
            Call<ProvincesResponse> call = covidStatsApi.getProvinces(iso, page, size, provinceNameFilter);
            return handleProvincesResponse(call, page, size, provinceNameFilter);
        }, apiExecutor);
    }

    private List<Region> handleRegionResponse(Call<RegionResponse> call, int page, int size) {
        try {
            Response<RegionResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                List<Region> regions = getRegionList(response);
                return paginateList(regions, page, size);
            } else {
                throw new ServiceCallException("Failed to get regions data with status code: " + response.code());
            }
        } catch (IOException exception) {
            throw new ServiceCallException("Regions API call failure", exception);
        }
    }

    private List<Provinces> handleProvincesResponse(Call<ProvincesResponse> call, int page, int size, String provinceNameFilter) {
        try {
            Response<ProvincesResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                List<Provinces> provinces = getProvincesList(response);

                if (provinceNameFilter != null && !provinceNameFilter.isEmpty()) {
                    provinces = filterByProvinceName(provinces, provinceNameFilter);
                }

                return paginateList(provinces, page, size);
            } else {
                throw new ServiceCallException("Failed to get provinces data with status code: " + response.code());
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
        return response.body().getRegionData();
    }

    private List<Provinces> getProvincesList(Response<ProvincesResponse> response) {
        return response.body().getProvincesData();
    }

    private <T> List<T> paginateList(List<T> list, int page, int size) {
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, list.size());
        if (startIndex >= list.size()) {
            return new ArrayList<>();
        }
        return list.subList(startIndex, endIndex);
    }
}
