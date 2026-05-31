package com.example.test.application.usecase;

import com.example.test.application.dto.request.CreateOrderRequest;
import com.example.test.application.dto.response.CreateOrderResponse;
import com.example.test.domain.event.OrderCreatedEvent;
import com.example.test.domain.port.out.OrderPersist;
import com.example.test.infra.mapper.OrderMapper;
import com.example.test.infra.messaging.publisher.OrderEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOrderUseCase {

    private final OrderPersist persist;

    private final OrderEventPublisher eventPublisher;

    private final OrderMapper mapper;

    public CreateOrderUseCase(OrderPersist persist, OrderEventPublisher eventPublisher, OrderMapper mapper) {
        this.persist = persist;
        this.eventPublisher = eventPublisher;
        this.mapper = mapper;
    }

    @Transactional
    public CreateOrderResponse save(CreateOrderRequest request) {
        var order = mapper.toOrder();
        order.addItems(request.items());
        persist.save(order);
        var event = new OrderCreatedEvent(order.getId(), order.getCorrelationId(), order.getItems(), order.getTotal());
        eventPublisher.send(event);
        return mapper.toResponse(order);
    }

}
