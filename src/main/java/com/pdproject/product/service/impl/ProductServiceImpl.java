package com.pdproject.product.service.impl;

import com.pdproject.product.exception.EntityNotFoundException;
import com.pdproject.product.model.Product;
import com.pdproject.product.repository.ProductRepository;
import com.pdproject.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository repository) {
        this.productRepository = repository;
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public void save(Product productDto) {
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
