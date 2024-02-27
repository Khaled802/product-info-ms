package com.example.composed.product.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.example.composed.product.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImp implements ProductService {
    private final RestTemplate restTemplate;

    @Override
    public Product getProduct(long id) {
        
        String uri = "http://localhost:8080/products/"+id;
        log.info("uri: {}", uri);
        try {
            return restTemplate.getForObject(uri, Product.class);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(e.getStatusCode());
        }
    }
    
}
