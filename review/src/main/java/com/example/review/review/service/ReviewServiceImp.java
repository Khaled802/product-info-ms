package com.example.review.review.service;

import com.example.review.review.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImp implements ReviewService {
    private final Map<Long, Review> reviews = Map.of(
            1L, new Review(1L, 1L, "Ali", "Reviewing milk teste", "....")
    );
    @Override
    public List<Review> getReviewByProductId(long productId) {
        return reviews.values().stream().filter(review -> review.productId() == productId).toList();
    }
}
