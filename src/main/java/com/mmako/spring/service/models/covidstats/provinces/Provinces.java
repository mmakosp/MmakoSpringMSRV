package com.mmako.spring.service.models.covidstats.provinces;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mmako.spring.config.CovidAPiDeserializer;

@JsonDeserialize(using = CovidAPiDeserializer.class)

public class Provinces {

    private String iso;
    private String name;
    private String province;

    private String lat;

    private String lng;

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
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLatitude() {
        return lat;
    }

    public void setLatitude(String latitude) {
        this.lat = latitude;
    }

    public String getLongitude() {
        return lng;
    }

    public void setLongitude(String longitude) {
        this.lng = longitude;
    }
}