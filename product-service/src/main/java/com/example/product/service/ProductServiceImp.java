package com.example.product.service;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.product.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImp implements ProductService {
    private final Map<Long, Product> products = Map.of(
        1L, new Product(1L, "Milk", 1000, "Maraee"),
        2L, new Product(2L, "Book", 3930, "Apress")
    );

    @Override
    public Product getProductById(long id) {

        log.info("id: {}", id);

        Product product = products.get(id);
        if (product == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return product;
    }

    
}
