package com.example.specificationpattern;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final Specification specification;

    public void order(OrderRequest orderRequest) {
        if(!specification.isSatisfy(orderRequest)) return;

        orderRepository.save();
    }
}
