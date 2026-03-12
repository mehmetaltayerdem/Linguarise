package com.linguarise.assessment.domain.port.out;

import com.linguarise.assessment.domain.model.PlacementTestResult;

import java.util.List;
import java.util.Optional;

public interface PlacementTestResultRepository {
    PlacementTestResult save(PlacementTestResult result);
    Optional<PlacementTestResult> findLatestByUserId(Long userId);
    List<PlacementTestResult> findAllByUserId(Long userId);
}