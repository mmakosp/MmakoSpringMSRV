package com.mmako.spring.service;

import com.mmako.spring.service.models.ServiceUser;
import org.springframework.stereotype.Service;

@Service
public class ServiceProfile {

        public ServiceUser serviceUser() {
        return new ServiceUser(
                "John",
                "Doe",
                "12345");
    }
}
