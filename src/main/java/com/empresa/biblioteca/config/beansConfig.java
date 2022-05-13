package com.empresa.biblioteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class beansConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
