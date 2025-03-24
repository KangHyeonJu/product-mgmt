package com.backend.product_mgmt.application;

import com.backend.product_mgmt.domain.Product;
import com.backend.product_mgmt.infrastructure.ListProductRepository;
import com.backend.product_mgmt.presentation.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {
    private ListProductRepository listProductRepository;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository){
        this.listProductRepository = listProductRepository;
    }

    public ProductDto add(ProductDto productDto){
        Product product = ??;

        Product savedProduct = listProductRepository.add(product);

        ProductDto savedProductDto = ??;

        return savedProductDto;
    }
}
