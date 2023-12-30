package com.example.testtask.data.request;

import com.example.testtask.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsRequest {

    private List<Product> records;
}
