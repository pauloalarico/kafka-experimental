package com.example.test.infra.messaging.publisher;

import com.example.test.domain.event.OrderCreatedEvent;

public interface OrderEventPublisher {
    void send(OrderCreatedEvent event);
}
