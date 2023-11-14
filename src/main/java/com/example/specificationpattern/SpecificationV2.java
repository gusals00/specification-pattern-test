package com.example.specificationpattern;

public interface SpecificationV2 {
    boolean isSatisfy(OrderRequest orderRequest);

    default SpecificationV2 and(SpecificationV2 other) {
        return orderRequest -> isSatisfy(orderRequest) && other.isSatisfy(orderRequest);
    }
    default SpecificationV2 or(SpecificationV2 other) {
        return orderRequest -> isSatisfy(orderRequest) || other.isSatisfy(orderRequest);
    }
    default SpecificationV2 not() {
        return orderRequest -> !isSatisfy(orderRequest);
    }
}
