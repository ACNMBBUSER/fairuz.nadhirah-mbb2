package com.fairuznadhirah.productprofile.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoredService {

    String boredUrl="https://www.boredapi.com/api/activity";

    public RestTemplate restTemplate = new RestTemplate();

    public BoredService(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public ResponseEntity<String> getBoredActivity(){
        ResponseEntity<String> response = restTemplate.exchange(boredUrl,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                });
        return response;
    }
}
