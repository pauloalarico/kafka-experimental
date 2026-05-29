package com.example.test.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "et_orders")
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    private UUID correlationId;

    private LocalDateTime createdAt;

    public static Order of() {
        Order order = new Order();
        order.id = null;
        order.correlationId = UUID.randomUUID();
        order.createdAt = LocalDateTime.now();
        return order;
    }
}
