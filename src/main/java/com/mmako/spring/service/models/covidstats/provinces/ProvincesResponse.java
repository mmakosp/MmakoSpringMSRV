package com.mmako.spring.service.models.covidstats.provinces;

import java.util.List;

public class ProvincesResponse {
    private List<Provinces> data;

    public List<Provinces> getProvincesData() {
        return data;
    }

    public void setProvincesData(List<Provinces> data) {
        this.data = data;
    }
}
