package com.example.test.domain.port.out;

import com.example.test.domain.model.Order;

import java.util.UUID;

public interface OrderPersist {
    void save(Order order);

    Order findByCorrelation(UUID correlation);

    Order findById(UUID id);
}
