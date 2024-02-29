package com.example.composed.product.service;

import com.example.composed.product.Product;
import com.example.composed.product.Recommendation;

import java.util.List;

public interface ProductService {
    Product getProduct(long id);

    List<Recommendation> getRecommendationByProductId(long productId);
}
