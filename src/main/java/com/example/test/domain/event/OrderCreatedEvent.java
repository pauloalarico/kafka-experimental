package com.example.test.domain.event;

import com.example.test.domain.model.Item;

import java.util.List;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID id,
        UUID correlationId,
        List<Item> items,
        EventStatus status
) {

    public OrderCreatedEvent(UUID id, UUID correlationId, List<Item> items) {
        this(id, correlationId, items, EventStatus.CREATED);
    }
}


