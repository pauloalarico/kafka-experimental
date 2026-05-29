package com.example.test.application.dto.response;

import com.example.test.domain.enums.EventStatus;
import com.example.test.domain.model.Item;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateOrderResponse(
        UUID id,
        UUID correlationId,
        EventStatus status,
        List<Item> items,
        LocalDateTime createdAt
) {
}
