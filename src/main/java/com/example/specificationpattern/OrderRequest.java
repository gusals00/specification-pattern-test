package com.example.specificationpattern;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderRequest {
    private int age;
}
