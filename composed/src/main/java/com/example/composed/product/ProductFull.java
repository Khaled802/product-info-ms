package com.example.composed.product;

import java.util.List;

public record ProductFull(Product product, List<Review> reviews, List<Recommendation> recommendations) {
}
