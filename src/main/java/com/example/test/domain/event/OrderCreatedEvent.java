package com.example.test.domain.event;

import com.example.test.domain.model.Item;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID id,
        UUID correlationId,
        List<Item> items,
        BigDecimal total,
        LocalDateTime createdAt,
        EventStatus status
) {

    public OrderCreatedEvent(UUID id, UUID correlationId, List<Item> items, BigDecimal total) {
        this(id, correlationId, items, total, LocalDateTime.now(), EventStatus.CREATED);
    }
}


