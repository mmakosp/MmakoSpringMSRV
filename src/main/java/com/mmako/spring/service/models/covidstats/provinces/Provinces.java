package com.mmako.spring.service.models.covidstats.provinces;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Provinces {

    private String iso;
    private String name;
    private String province;

    @JsonProperty("lat")
    private String latitude;

    @JsonProperty("long")
    private String longitude;

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return iso;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}