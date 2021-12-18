package com.actionservice.config;

import com.actionservice.model.Website;
import com.actionservice.model.dto.Websites;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebsiteDeserializer extends StdDeserializer<Websites> {

    public WebsiteDeserializer() {
        this(Website.class);
    }

    protected WebsiteDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Websites deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        List<Website> websiteList = new ArrayList<>();
        JsonNode node = jp.getCodec().readTree(jp);
        for (int i = 0; i <  node.size(); i++) {
            Website website = new Website();
            JsonNode jsonNode = node.get(i);
            JsonNode status = jsonNode.get("status");
            JsonNode id = jsonNode.get("id");
            JsonNode name = jsonNode.get("name");
            website.setAdmitadId(id.asLong());
            website.setName(name.asText());
            website.setStatus(status.asText());
            websiteList.add(website);
        }
        Websites websites = new Websites();
        websites.setWebsites(websiteList);
        return websites;
    }
}
