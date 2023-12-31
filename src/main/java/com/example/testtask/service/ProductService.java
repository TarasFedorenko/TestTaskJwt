package com.example.testtask.service;

import com.example.testtask.entity.Product;

import java.util.List;

public interface ProductService {
    void addProducts(List<Product> products);
    List<Product> getAllProducts();
}
