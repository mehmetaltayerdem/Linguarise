package com.linguarise.assessment.domain.port.out;

import java.time.Duration;

public interface CooldownStore {
    boolean hasCooldown(Long userId);
    void putCooldown(Long userId, Duration ttl);
}