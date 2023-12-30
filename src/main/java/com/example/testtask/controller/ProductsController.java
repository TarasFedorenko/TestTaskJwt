package com.example.testtask.controller;

import com.example.testtask.data.request.ProductsRequest;
import com.example.testtask.entity.Product;
import com.example.testtask.service.ProductService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProducts(@RequestBody ProductsRequest productsRequest) {
        productService.addProducts(productsRequest.getRecords());
        return ResponseEntity.ok("Product added");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}