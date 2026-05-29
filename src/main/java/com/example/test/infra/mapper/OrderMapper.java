package com.example.test.infra.mapper;

import com.example.test.application.dto.response.CreateOrderResponse;
import com.example.test.domain.enums.EventStatus;
import com.example.test.domain.model.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapper {

    public Order toOrder() {
        return Order.of();
    }

    public CreateOrderResponse toResponse(Order order) {
        return new CreateOrderResponse(
                order.getId(), order.getCorrelationId(),
                EventStatus.CREATED, order.getItems(), LocalDateTime.now()
        );
    }

}
