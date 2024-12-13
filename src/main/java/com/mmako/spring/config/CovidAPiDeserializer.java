package com.mmako.spring.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.mmako.spring.service.models.covidstats.provinces.Provinces;

import java.io.IOException;

public class CovidAPiDeserializer extends JsonDeserializer<Provinces> {

    @Override
    public Provinces deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        Provinces province = new Provinces();
        province.setIso(node.get("iso").asText());
        province.setName(node.get("name").asText());
        province.setProvince(node.get("province").asText());
        province.setLatitude(node.get("lat").asText());

        province.setLongitude(node.get("long").asText());

        return province;
    }
}
