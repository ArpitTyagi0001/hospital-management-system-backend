package com.example.HospitalMangement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        // this is used to post request of appointment to ignore the id
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true);

        return modelMapper;
    }
}
