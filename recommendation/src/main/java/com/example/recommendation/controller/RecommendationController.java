package com.example.recommendation.controller;

import com.example.recommendation.Recommendation;
import com.example.recommendation.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    @GetMapping("/{id}")
    public Recommendation getRecommendation(@PathVariable("id") long id) {
        return recommendationService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "not found recommendation"));
    }

    @GetMapping("/product/{productId}")
    public List<Recommendation> getRecommendationsOfProduct(@PathVariable("productId") long id) {
        return recommendationService.findByProductId(id);
    }
}
