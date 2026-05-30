package com.example.test.infra.persistence.repository;

import com.example.test.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT * FROM Order o WHERE O.id = :id")
    Optional<Order> findOrderById(UUID id);

    @Query("SELECT * FROM Order o WHERE O.correlationId = :correlation")
    Optional<Order> findOrderByCorrelation(@Param("correlation") UUID correlationId);

}
