package com.example.specificationpattern;

public interface Specification {
    boolean isSatisfy(OrderRequest orderRequest);
    Specification and(Specification other);
    Specification or(Specification other);
    Specification not();
}
