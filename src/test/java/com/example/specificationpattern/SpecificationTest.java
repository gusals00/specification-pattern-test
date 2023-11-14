package com.example.specificationpattern;

import com.example.specificationpattern.OrderRequest.OrderRequestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SpecificationTest {

    private Specification sut;
    private SpecificationV2 sut2;
    private Predicate<OrderRequest> sut3;
    private OrderRequestBuilder orderRequestBuilder;

    @BeforeEach
    void setUp() {
        orderRequestBuilder = OrderRequest.builder();
    }

    @Test
    void specification() {
        OrderRequest orderRequest = orderRequestBuilder.age(11).build();
        OrderRequest orderRequest2 = orderRequestBuilder.age(20).build();

        sut = createAgeSpecification().and(createAge2Specification());

        assertThat(sut.isSatisfy(orderRequest)).isTrue();
        assertThat(sut.isSatisfy(orderRequest2)).isFalse();
    }

    @Test
    void specificationV2() {
        OrderRequest orderRequest = orderRequestBuilder.age(11).build();
        OrderRequest orderRequest2 = orderRequestBuilder.age(20).build();

        sut2 = ((SpecificationV2) orderRequest1 -> orderRequest1.getAge() > 10)
                .and(orderRequest12 -> orderRequest12.getAge() < 20);

        assertThat(sut2.isSatisfy(orderRequest)).isTrue();
        assertThat(sut2.isSatisfy(orderRequest2)).isFalse();
    }

    @Test
    void specificationV3() {
        OrderRequest orderRequest = orderRequestBuilder.age(11).build();
        OrderRequest orderRequest2 = orderRequestBuilder.age(20).build();

        sut3 = ageOlderSpecification(10)
                .and(ageYoungerSpecification(20));

        assertThat(sut3.test(orderRequest)).isTrue();
        assertThat(sut3.test(orderRequest2)).isFalse();
    }

    private Predicate<OrderRequest> ageOlderSpecification(int age) {
        return orderRequest -> orderRequest.getAge() > age;
    }

    private Predicate<OrderRequest> ageYoungerSpecification(int age) {
        return orderRequest -> orderRequest.getAge() < age;
    }

    private CompositeSpecification createAgeSpecification() {
        return new CompositeSpecification() {
            @Override
            public boolean isSatisfy(OrderRequest orderRequest) {
                return orderRequest.getAge() > 10;
            }
        };
    }

    private CompositeSpecification createAge2Specification() {
        return new CompositeSpecification() {
            @Override
            public boolean isSatisfy(OrderRequest orderRequest) {
                return orderRequest.getAge() < 20;
            }
        };
    }
}
