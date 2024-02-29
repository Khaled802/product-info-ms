package com.example.composed.product;

public record Recommendation(long id, long productId, String auth, int rate, String content) {
}
