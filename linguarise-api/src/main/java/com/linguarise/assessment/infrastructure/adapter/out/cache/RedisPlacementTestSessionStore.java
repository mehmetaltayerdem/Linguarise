package com.linguarise.assessment.infrastructure.adapter.out.cache;

import com.linguarise.assessment.domain.model.PlacementTestSession;
import com.linguarise.assessment.domain.port.out.PlacementTestSessionStore;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RedisPlacementTestSessionStore implements PlacementTestSessionStore {

    private final StringRedisTemplate redisTemplate;

    private String key(String testId) {
        return "placement_session:" + testId;
    }

    @Override
    public void save(PlacementTestSession session, Duration ttl) {
        String value = session.userId() + "|" + session.startedAt();
        redisTemplate.opsForValue().set(key(session.testId()), value, ttl);
    }

    @Override
    public Optional<PlacementTestSession> findByTestId(String testId) {
        String value = redisTemplate.opsForValue().get(key(testId));
        if (value == null || value.isBlank()) {
            return Optional.empty();
        }

        String[] parts = value.split("\\|", 2);
        if (parts.length != 2) {
            return Optional.empty();
        }

        Long userId = Long.parseLong(parts[0]);
        LocalDateTime startedAt = LocalDateTime.parse(parts[1]);

        return Optional.of(new PlacementTestSession(testId, userId, startedAt));
    }

    @Override
    public void delete(String testId) {
        redisTemplate.delete(key(testId));
    }
}