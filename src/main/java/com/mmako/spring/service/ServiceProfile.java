package com.mmako.spring.service;

import com.mmako.spring.service.models.ServiceUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ServiceProfile {

    @Value("${spring.profiles.active}")
    private String activeProfile;
        public ServiceUser serviceUser() {
        return new ServiceUser(
                "John",
                "Doe",
                "12345");
    }

    @GetMapping("/")
    public String homePage() {
        return "Welcome to Spring Profile" + activeProfile + "environment" ;
    }
}
