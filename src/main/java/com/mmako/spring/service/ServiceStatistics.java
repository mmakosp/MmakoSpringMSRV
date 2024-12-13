package com.mmako.spring.service;
import com.mmako.spring.service.models.covidstats.provinces.Provinces;
import com.mmako.spring.service.models.covidstats.regions.Region;
import java.util.List;

public interface ServiceStatistics {

    List<Region> getRegions(int page, int size);
    List<Provinces> getProvinces(String iso, int page, int size, String provinceNameFilter);
}