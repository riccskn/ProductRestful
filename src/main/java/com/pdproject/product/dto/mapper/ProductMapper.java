package com.pdproject.product.dto.mapper;

import com.pdproject.product.dto.ProductDTO;
import com.pdproject.product.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toModel(ProductDTO productDto);

    ProductDTO toDTO(Product product);

}
