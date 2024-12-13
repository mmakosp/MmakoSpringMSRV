package com.mmako.spring.controller;

import com.mmako.spring.exception.ServiceCallException;
import com.mmako.spring.service.ServiceStatistics;
import com.mmako.spring.service.models.covidstats.provinces.Provinces;
import com.mmako.spring.service.models.covidstats.regions.Region;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CacheConfig(cacheNames = "covidStats")
public class CovidStatsController {

    private final ServiceStatistics serviceStatistics;

    public CovidStatsController(ServiceStatistics serviceStatistics) {
        this.serviceStatistics = serviceStatistics;
    }

    @GetMapping("/api/regions")
    public ResponseEntity<List<Region>> getRegions(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) {
        try {
            List<Region> regions = serviceStatistics.getRegions(page, size);
            return ResponseEntity.ok(regions);
        } catch (ServiceCallException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of());
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of());
        }
    }

    @GetMapping("/api/provinces")
    public ResponseEntity<List<Provinces>> getProvinces(
            @RequestParam(value = "iso") String iso,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(required = false) String provinceNameFilter
            ) {
        try {
            List<Provinces> provinces = serviceStatistics.getProvinces(iso, page, size, provinceNameFilter);
            return ResponseEntity.ok(provinces);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(List.of());
        }
    }
}
