package com.example.recommendation.service;

import com.example.recommendation.Recommendation;

import java.util.List;
import java.util.Optional;

public interface RecommendationService {
    Optional<Recommendation> findById(long id);
    List<Recommendation> findByProductId(long id);
}
