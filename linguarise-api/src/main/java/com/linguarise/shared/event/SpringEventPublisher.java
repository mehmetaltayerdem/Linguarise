package com.linguarise.shared.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * MVP implementation: publishes domain events via Spring ApplicationEvents.
 * Will be replaced by KafkaEventPublisher in Faz 3.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SpringEventPublisher implements EventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publish(DomainEvent event) {
        log.info("Publishing event: {} at {}", event.getEventType(), event.getOccurredAt());
        applicationEventPublisher.publishEvent(event);
    }
}
