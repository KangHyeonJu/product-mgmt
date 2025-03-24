package com.backend.product_mgmt.application;

import com.backend.product_mgmt.domain.Product;
import com.backend.product_mgmt.infrastructure.ListProductRepository;
import com.backend.product_mgmt.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleProductService {
    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper){
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);

        Product savedProduct = listProductRepository.add(product);

        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }
}
