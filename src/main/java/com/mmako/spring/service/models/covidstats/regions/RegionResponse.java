package com.mmako.spring.service.models.covidstats.regions;

import java.util.List;

public class RegionResponse {
    private List<Region> data;

    public List<Region> getRegionData() {
        return data;
    }

    public void setRegionData(List<Region> data) {
        this.data = data;
    }
}
