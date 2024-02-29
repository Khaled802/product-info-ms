package com.example.composed.product.controller;

import com.example.composed.product.Recommendation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.composed.product.Product;
import com.example.composed.product.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/hi/hi")
    public String getMethodName() {
        return "Hello";
    }
    
    @GetMapping("/{id}")
    Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/recommendations/{productId}")
    List<Recommendation> getRecommendations(@PathVariable Long productId) {
        return productService.getRecommendationByProductId(productId);
    }

    
}
