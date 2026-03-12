package com.linguarise.shared.event;

/**
 * Output port for publishing domain events.
 * MVP: Implemented by SpringEventPublisher (ApplicationEventPublisher).
 * Faz 3: Will be implemented by KafkaEventPublisher.
 */
public interface EventPublisher {
    void publish(DomainEvent event);
}
