package com.mmako.spring.controller;

import com.mmako.spring.service.ServiceStatistics;
import com.mmako.spring.service.ServiceStatisticsImplementation;
import com.mmako.spring.service.api.CovidStatsApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import retrofit2.Retrofit;

import java.util.concurrent.Executor;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public CovidStatsApi covidStatsApi(Retrofit retrofit) {
        return retrofit.create(CovidStatsApi.class);
    }

    @Bean
    public ServiceStatistics serviceStatistics(Retrofit retrofit, Executor apiExecutor) {
        return new ServiceStatisticsImplementation(retrofit, apiExecutor);
    }

    @Bean(name = "apiExecutor")
    public Executor apiExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(50);
        executor.setThreadNamePrefix("ApiExecutor-");
        executor.initialize();
        return executor;
    }

    @Bean
    public String successMessage() {
        return "Hello World";
    }
}