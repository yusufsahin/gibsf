package com.example.sf903datajpa.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(List<ModelMapperConfigurer> configurers) {
        ModelMapper modelMapper = new ModelMapper();
        for (ModelMapperConfigurer configurer : configurers) {
            configurer.configure(modelMapper);
        }
        return modelMapper;
    }

}