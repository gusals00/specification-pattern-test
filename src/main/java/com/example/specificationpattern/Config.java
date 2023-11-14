package com.example.specificationpattern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class Config {

    @Bean
    public Predicate<OrderRequest> agePolicy() {
        return ageOlderSpecification(10).and(ageYoungerSpecification(20));
    }

    private Predicate<OrderRequest> ageOlderSpecification(int age) {
        return orderRequest12 -> orderRequest12.getAge() > age;
    }

    private Predicate<OrderRequest> ageYoungerSpecification(int age) {
        return orderRequest12 -> orderRequest12.getAge() < age;
    }
}
