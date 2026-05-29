package com.example.test.presentation.controller;

import com.example.test.application.dto.request.CreateOrderRequest;
import com.example.test.application.dto.response.CreateOrderResponse;
import com.example.test.application.usecase.CreateOrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final CreateOrderUseCase createOrder;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> create(@RequestBody CreateOrderRequest request) {
        var response = createOrder.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("{id}")
                .buildAndExpand(response.correlationId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
