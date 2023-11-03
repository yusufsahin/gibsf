package com.example.sf300springtest.config;

import com.example.sf300springtest.di.Motor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("benzinli")
public class BenzinliConfig {

    @Bean
    public Motor motor() {
        return new Motor("Benzinli");
    }
}