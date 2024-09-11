package com.mmako.spring.service.api;

import com.mmako.spring.service.models.covidstats.provinces.ProvincesResponse;
import com.mmako.spring.service.models.covidstats.regions.RegionResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CovidStatsApi {

    @GET("provinces")
    Call<ProvincesResponse> getProvinces(@Query("iso") String iso, @Query("page") int page, @Query("size") int size);

    @GET("regions")
    Call<RegionResponse> getRegions(@Query("page") int page, @Query("size") int size);
}
