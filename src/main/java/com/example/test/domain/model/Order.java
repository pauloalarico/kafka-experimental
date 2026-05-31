package com.example.test.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
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

    @OneToMany(mappedBy = "ct_orders", cascade = CascadeType.DETACH, orphanRemoval = true)
    private List<Item> items;

    private LocalDateTime createdAt;

    private BigDecimal total;

    public static Order of() {
        Order order = new Order();
        order.id = null;
        order.correlationId = UUID.randomUUID();
        order.createdAt = LocalDateTime.now();
        order.total = null;
        return order;
    }

    public void addItems(List<Item> i) {
        this.items.addAll(i);
        calculateTotal();
    }

    private void calculateTotal() {
        this.total = items.stream().map(
                i -> new BigDecimal(i.getQuantity()).multiply(i.getProduct().value()))
                .reduce(this.total != null ? total : BigDecimal.ZERO, BigDecimal::add);
    }

    public void addItem(Item i) {
        this.items.add(i);
    }
}
