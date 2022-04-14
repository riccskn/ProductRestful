package com.pdproject.product.service.impl;

import com.pdproject.product.dto.ProductDTO;
import com.pdproject.product.exception.EntityNotFoundException;
import com.pdproject.product.model.Product;
import com.pdproject.product.repository.ProductRepository;
import com.pdproject.product.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ProductDTO findById(long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));

        return mapper.map(product,ProductDTO.class);

    }

    @Override
    public List<Product> findAll() {
       return productRepository.findAll();
    }

    @Override
    public void save(ProductDTO productDTO) {

        productRepository.save(mapper.map(productDTO, Product.class));

    }

    @Override
    public void deleteById(long id) {

        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException(id);
        });

        productRepository.deleteById(id);
    }
}
