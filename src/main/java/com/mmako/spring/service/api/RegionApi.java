//package com.mmako.spring.service.api;
//
//import com.mmako.spring.service.models.covidstats.regions.RegionResponse;
//import retrofit2.Call;
//import retrofit2.http.GET;
//import retrofit2.http.Headers;
//import retrofit2.http.Query;
//
//public interface RegionApi {
//
//    @Headers({
//            "X-RapidAPI-Key: 8c9f5233c0msh33fdedb1e337962p1495e1jsn484293744d4b",
//            "X-RapidAPI-Host: covid-19-statistics.p.rapidapi.com"
//    })
//    @GET("regions")
//    Call<RegionResponse> getRegions(@Query("page") int page, @Query("size") int size);
//}
