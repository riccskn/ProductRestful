package com.pdproject.product.service.impl;

import com.pdproject.product.dto.ProductDTO;
import com.pdproject.product.dto.mapper.ProductMapper;
import com.pdproject.product.exception.EntityNotFoundException;
import com.pdproject.product.model.Product;
import com.pdproject.product.repository.ProductRepository;
import com.pdproject.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ProductMapper productMapper;

     ModelMapper

    public ProductServiceImpl(ProductRepository repository,ProductMapper mapper) {
        this.productRepository = repository;
        this.productMapper = mapper;
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public void save(ProductDTO productDTO) {
        productRepository.save(Produc);
    }

    @Override
    public void deleteById(long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(id);
        });

        productRepository.deleteById(id);
    }
}
