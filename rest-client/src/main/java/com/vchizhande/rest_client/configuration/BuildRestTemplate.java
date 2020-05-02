package com.vchizhande.rest_client.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class BuildRestTemplate {

    public static RestTemplate restTemplate() {

        return new RestTemplateBuilder()
                .basicAuthentication("vara", "abc")
                .build();

    }
}
