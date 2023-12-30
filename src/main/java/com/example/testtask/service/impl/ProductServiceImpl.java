package com.example.testtask.service.impl;

import com.example.testtask.entity.Product;
import com.example.testtask.repository.ProductRepository;
import com.example.testtask.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void addProducts(List<Product> products) {
        if (products != null) {
            productRepository.saveAll(products);
        } else {
            throw new RuntimeException("No products in list");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
