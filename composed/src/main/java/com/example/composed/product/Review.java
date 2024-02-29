package com.example.composed.product;

public record Review(Long id, Long productId, String author, String subject, String content) {
}
