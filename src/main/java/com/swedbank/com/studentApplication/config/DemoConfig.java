package com.swedbank.com.studentApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean
    public DemoBean demoBean(){
        return new DemoBean();
    }
}
