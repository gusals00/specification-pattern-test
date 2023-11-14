package com.example.specificationpattern;

public class AndSpecification extends CompositeSpecification {

    private Specification left;
    private Specification right;

    public AndSpecification(Specification left, Specification right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isSatisfy(OrderRequest orderRequest) {
        return left.isSatisfy(orderRequest) && right.isSatisfy(orderRequest);
    }
}
