package com.mmako.spring.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public String successMessage() {
        return "Hello World";
    }
}
