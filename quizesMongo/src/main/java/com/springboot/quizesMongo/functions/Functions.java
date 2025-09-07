package com.springboot.quizesMongo.functions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class Functions {

    @Bean
    public Supplier<String> getInformation(){
        return ()->"Hello world";
    }



}
