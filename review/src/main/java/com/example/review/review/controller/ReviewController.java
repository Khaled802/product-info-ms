package com.example.review.review.controller;

import com.example.review.review.Review;
import com.example.review.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/products/{productId}")
    public List<Review> getReviewOfProduct(@PathVariable Long productId) {
        return reviewService.getReviewByProductId(productId);
    }
}
