package com.example.test.application.dto.request;

import com.example.test.domain.model.Item;

import java.util.List;

public record CreateOrderRequest(
        List<Item> items
) {
}
