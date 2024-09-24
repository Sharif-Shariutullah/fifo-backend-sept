package com.example.fifotech.services.customer;

import com.example.fifotech.dto.ProductDetailDto;
import com.example.fifotech.dto.ProductDto;

import java.util.List;

public interface CustomerProductService {

    List<ProductDto> getAllProducts();


//    List<ProductDto> getAllProductsByName(String name);

    List<ProductDto> searchProductsByTitle(String title);

    ProductDetailDto getProductDetailById(Long productId);
}
