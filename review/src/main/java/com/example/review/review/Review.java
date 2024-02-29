package com.example.review.review;

public record Review(Long id, Long productId, String author, String subject, String content) {
}
