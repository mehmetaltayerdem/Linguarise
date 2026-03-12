package com.linguarise.shared.event;

import java.time.LocalDateTime;

public interface DomainEvent {
    String getEventType();
    LocalDateTime getOccurredAt();
}
