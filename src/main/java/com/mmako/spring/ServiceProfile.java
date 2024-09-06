package com.mmako.spring;

import org.springframework.stereotype.Service;

@Service
public class ServiceProfile {

        public ServiceUser serviceUser() {
        return new ServiceUser(
                "Mmako",
                "Sekhosana",
                "12345");
    }
}
