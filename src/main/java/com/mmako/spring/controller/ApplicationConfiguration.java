package com.mmako.spring.controller;
import com.mmako.spring.service.api.CovidStatsApi;
import com.mmako.spring.service.ServiceStatistics;
import com.mmako.spring.service.ServiceStatisticsImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CovidStatsApi covidStatsApi(Retrofit retrofit) {
        return retrofit.create(CovidStatsApi.class);
    }

    @Bean
    public ServiceStatistics serviceStatistics(Retrofit retrofit) {
        return new ServiceStatisticsImplementation(retrofit);
    }

    @Bean
    public String successMessage() {
        return "Hello World";
    }
}
