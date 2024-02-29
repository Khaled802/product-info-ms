package com.example.composed.product.service;

import com.example.composed.product.Recommendation;
import com.example.composed.product.Review;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.example.composed.product.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService {
    private final RestTemplate restTemplate;

    @Override
    public Product getProduct(long id) {

        String uri = "http://localhost:8080/products/" + id;
        log.info("uri: {}", uri);
        try {
            return restTemplate.getForObject(uri, Product.class);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

    @Override
    public List<Recommendation> getRecommendationByProductId(long productId) {
        String uri = "http://localhost:8082/recommendations/product/" + productId;
        log.info("uri: {}", uri);
        try {
            return restTemplate.exchange(uri, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Recommendation>>() {
                    }).getBody();
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

    @Override
    public List<Review> getReviewsByProductId(long productId) {
        String uri = "http://localhost:8083/reviews/products/" + productId;
        log.info("uri: {}", uri);
        try {
            return restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Review>>() {})
                    .getBody();
        } catch (HttpClientErrorException e) {
            throw  new ResponseStatusException(e.getStatusCode());
        }
    }

}
