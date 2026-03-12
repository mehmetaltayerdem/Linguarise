package com.linguarise.assessment.infrastructure.adapter.out.cache;

import com.linguarise.assessment.domain.port.out.CooldownStore;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RedisCooldownStore implements CooldownStore {

    private final StringRedisTemplate redisTemplate;

    private String key(Long userId) {
        return "placement_cd:" + userId;
    }

    @Override
    public boolean hasCooldown(Long userId) {
        Boolean exists = redisTemplate.hasKey(key(userId));
        return Boolean.TRUE.equals(exists);
    }

    @Override
    public void putCooldown(Long userId, Duration ttl) {
        redisTemplate.opsForValue().set(key(userId), "1", ttl);
    }
}