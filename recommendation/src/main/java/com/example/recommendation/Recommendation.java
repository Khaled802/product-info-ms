package com.example.recommendation;

public record Recommendation(long id, long productId, String auth, int rate, String content) {

}
