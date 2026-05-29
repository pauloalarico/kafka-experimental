package com.example.test.application.usecase;

import com.example.test.application.dto.request.CreateOrderRequest;
import com.example.test.application.dto.response.CreateOrderResponse;
import com.example.test.domain.port.out.OrderPersist;
import com.example.test.infra.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOrderUseCase {

    private final OrderPersist persist;

    private final OrderMapper mapper;

    public CreateOrderUseCase(OrderPersist persist, OrderMapper mapper) {
        this.persist = persist;
        this.mapper = mapper;
    }

    @Transactional
    public CreateOrderResponse save(CreateOrderRequest request) {
        var order = mapper.toOrder();
        order.addItems(request.items());
        return mapper.toResponse(order);
    }

}
