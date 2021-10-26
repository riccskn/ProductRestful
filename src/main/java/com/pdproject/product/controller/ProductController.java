package com.pdproject.product.controller;

import com.pdproject.product.model.Product;
import com.pdproject.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getProducts() {

        return repository.findAll();

    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(value = "id") long id) {

      return repository.findById(id);

    }

    @PostMapping("/product")
       public Product saveProduct(@RequestBody Product product) {

       return repository.save(product);

    }

    @DeleteMapping("/product")
    public void deleteProduct(@RequestBody Product product) {

       repository.delete(product);

    }

    @PutMapping("/product")
      public Product updateProduct(@RequestBody Product product) {

       return repository.save(product);

    }

}
