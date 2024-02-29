package com.example.composed.product.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.server.ResponseStatusException;

import com.example.composed.product.Product;
import com.example.composed.product.service.ProductService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    private final long ACCEPTED_ID = 1L;
    private final long NOT_FOUND_ID = 2L;

    @MockBean
    private ProductService productService;


    @BeforeEach
    void setup() {
        given(productService.getProduct(ACCEPTED_ID)).willReturn(new Product(ACCEPTED_ID, "product1", 1000, "fomds"));
        given(productService.getProduct(NOT_FOUND_ID)).willThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Test
    void testGetProduct() {
        webTestClient.get().uri("/products/"+ACCEPTED_ID).accept(MediaType.APPLICATION_JSON).exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$.id").isEqualTo(1);
    }

    @Test
    void testGetProductWithNotFound() {
        webTestClient.get().uri("/products/"+NOT_FOUND_ID).accept(MediaType.APPLICATION_JSON).exchange()
            .expectStatus().isNotFound();
    }
}
