package com.backend.product_mgmt.application;

import com.backend.product_mgmt.domain.Product;
import com.backend.product_mgmt.domain.ProductRepository;
import com.backend.product_mgmt.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {
    private ProductRepository productRepository;
    private ValidationService validationService;

    @Autowired
    SimpleProductService(ProductRepository productRepository, ValidationService validationService){
        this.productRepository = productRepository;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto){
        Product product = ProductDto.toEntity(productDto);
        validationService.checkValid(product);

        Product savedProduct = productRepository.add(product);
        ProductDto savedProductDto = ProductDto.toDto(savedProduct);

        return savedProductDto;
    }

    public ProductDto findById(Long id){
        Product product = productRepository.findById(id);
        ProductDto productDto = ProductDto.toDto(product);

        return productDto;
    }

    public List<ProductDto> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                    .map(product -> ProductDto.toDto(product))
                    .toList();

        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name){
        List<Product> products = productRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();

        return productDtos;
    }

    public ProductDto update(ProductDto productDto){
        Product product = ProductDto.toEntity(productDto);
        Product updateProduct = productRepository.update(product);
        ProductDto updateProductDto = ProductDto.toDto(updateProduct);

        return updateProductDto;
    }

    public void delete(Long id){
        productRepository.delete(id);
    }
}
