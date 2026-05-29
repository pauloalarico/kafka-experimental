package com.example.test.infra.repository;

import com.example.test.domain.model.Order;
import com.example.test.domain.port.out.OrderPersist;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryI implements OrderPersist  {

    private final OrderRepository repository;

    @Override
    public void save(Order order) {
        repository.save(order);
    }

    @Override
    public Order findByCorrelation(UUID correlation) {
        return repository.findOrderByCorrelation(correlation).orElseThrow(
                () -> new EntityNotFoundException("Could not find the order for the correlation id!"));
    }

    @Override
    public Order findById(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find the order for this id"));
    }

}
