package com.example.review.review.service;

import com.example.review.review.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewByProductId(long id);
}
