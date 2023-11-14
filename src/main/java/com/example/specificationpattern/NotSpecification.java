package com.example.specificationpattern;

public class NotSpecification extends CompositeSpecification {

    private Specification spec;

    public NotSpecification(Specification spec) {
        this.spec = spec;
    }

    @Override
    public boolean isSatisfy(OrderRequest orderRequest) {
        return !spec.isSatisfy(orderRequest);
    }
}
