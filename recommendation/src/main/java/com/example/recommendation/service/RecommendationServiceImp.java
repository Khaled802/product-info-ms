package com.example.recommendation.service;

import com.example.recommendation.Recommendation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RecommendationServiceImp implements RecommendationService {
    private final Map<Long, Recommendation> recommendations = Map.of(
            1L, new Recommendation(1L, 1L, "Khaled", 3, "It is nice but not the best"),
            2L, new Recommendation(2L, 1L, "Ahmed", 2, "It is yukkkkky")
    );

    @Override
    public Optional<Recommendation> findById(long id) {
        return Optional.of(recommendations.get(id));
    }

    @Override
    public List<Recommendation> findByProductId(long id) {
        return recommendations.values()
                .stream()
                .filter(recommendation -> recommendation.productId() == id)
                .toList();
    }
}
