package com.linguarise.assessment.domain.port.out;

import com.linguarise.assessment.domain.model.PlacementTestSession;

import java.time.Duration;
import java.util.Optional;

public interface PlacementTestSessionStore {
    void save(PlacementTestSession session, Duration ttl);
    Optional<PlacementTestSession> findByTestId(String testId);
    void delete(String testId);
}