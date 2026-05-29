package com.example.test.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;

@Embeddable
record Product(String name, BigDecimal value, @Enumerated(EnumType.STRING) ProductType type) {

    enum ProductType {
        FOOD,
        CLOTHING,
        ELECTRONIC,
        HOME,
        PERSONAL,
        TOYS,
        MEDIA
    }
}
