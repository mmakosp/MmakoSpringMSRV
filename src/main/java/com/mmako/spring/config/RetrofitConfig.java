package com.mmako.spring.config;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetrofitConfig {

    @Value("${api.base.url}")
    private String baseUrl;

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.host}")
    private String apiHost;

    @Bean
    public Retrofit retrofit() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    return chain.proceed(
                            chain.request().newBuilder()
                                    .addHeader("X-RapidAPI-Key", apiKey)
                                    .addHeader("X-RapidAPI-Host", apiHost)
                                    .build()
                    );
                })
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
