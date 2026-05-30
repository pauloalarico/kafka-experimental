package com.example.test.infra.messaging.publisher;

import com.example.test.domain.event.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaOrderEventPublished implements OrderEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.producer.topic}")
    private String topicName;

    public KafkaOrderEventPublished(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(OrderCreatedEvent event) {
        kafkaTemplate.send(topicName, event.correlationId().toString(), event)
                .whenComplete((r, e) -> {
                    if (e != null) {
                        log.error("Could not send message due to: {}", e.getMessage());
                        throw new IllegalArgumentException("Error sending message");
                    }
                    log.info("Message sent for correlationId: {}", event.correlationId());
                });
    }
}
