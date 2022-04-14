package com.pdproject.product.controller;

import com.pdproject.product.dto.ProductDTO;
import com.pdproject.product.model.Product;
import com.pdproject.product.repository.ProductRepository;
import com.pdproject.product.service.ProductService;
import com.pdproject.product.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    @Autowired
    ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @Operation(summary = "Get all products", description = "This return the all products saved")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Product.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid status value") })
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts() {

        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);

    }


    @Operation(summary = "Get product by id", description = "Return only one product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Product.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid status value") })
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(value = "id") long id) {

      return new ResponseEntity<>(productService.findById(id),HttpStatus.OK);
    }


    @Operation(summary = "Delete product by id", description = "Multiple status values can be provided with comma separated strings")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Product not found") })
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") long id) {

        productService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }


    @Operation(summary = "Create new product", description = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created"),
            @ApiResponse(responseCode = "400", description = "Invalid body") })
    @PostMapping("/product")
       public ResponseEntity<Void> saveProduct(@Valid @RequestBody ProductDTO product) {

        productService.save(product);

       return new ResponseEntity<Void>(HttpStatus.CREATED);

    }


    @Operation(summary = "Update product", description = "Update an existing product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid body") })
    @PutMapping("/product/{id}")
      public ResponseEntity<Void> updateProduct(@Valid @RequestBody ProductDTO product) {

       productService.save(product);

        return new ResponseEntity<Void>(HttpStatus.OK);


    }

}
