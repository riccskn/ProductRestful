package com.pdproject.product.service;

import com.pdproject.product.dto.ProductDTO;
import com.pdproject.product.model.Product;

import java.util.List;

public interface ProductService {

    ProductDTO findById(long id);

    List<Product> findAll();

    void save(ProductDTO productDTO);

    void deleteById(long id);

}
