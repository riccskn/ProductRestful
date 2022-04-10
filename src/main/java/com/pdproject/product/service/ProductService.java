package com.pdproject.product.service;

import com.pdproject.product.model.Product;

import java.util.List;

public interface ProductService {

    Product findById(long id);

    List<Product> findAll();

    void save(Product product);

    void deleteById(long id);

}
