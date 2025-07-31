package com.backend.product_mgmt.application;

import com.backend.product_mgmt.domain.Product;
import com.backend.product_mgmt.domain.ProductMapper;
import com.backend.product_mgmt.domain.ProductRepository;
import com.backend.product_mgmt.presentation.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleProductService {
    private final ProductRepository productRepository;
    private final ValidationService validationService;

    private final ProductMapper productMapper;


    public ProductDto add(ProductDto productDto){
        Product product = ProductDto.toEntity(productDto);
        validationService.checkValid(product);

//        Product savedProduct = productRepository.add(product);
        productMapper.add(product);
        Product savedProduct = productMapper.findById(product.getId());
        ProductDto savedProductDto = ProductDto.toDto(savedProduct);

        return savedProductDto;
    }

    public ProductDto findById(Long id){
//        Product product = productRepository.findById(id);
        Product product = productMapper.findById(id);
        ProductDto productDto = ProductDto.toDto(product);

        return productDto;
    }

    public List<ProductDto> findAll(){
//        List<Product> products = productRepository.findAll();
        List<Product> products = productMapper.findAll();

        List<ProductDto> productDtos = products.stream()
                    .map(product -> ProductDto.toDto(product))
                    .toList();

        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name){
//        List<Product> products = productRepository.findByNameContaining(name);
        List<Product> products = productMapper.findByNameContaining(name);

        List<ProductDto> productDtos = products.stream()
                .map(product -> ProductDto.toDto(product))
                .toList();

        return productDtos;
    }

    public ProductDto update(ProductDto productDto){
        Product product = ProductDto.toEntity(productDto);
//        Product updateProduct = productRepository.update(product);
        productMapper.update(product);
        Product updateProduct = productMapper.findById(product.getId());
        ProductDto updateProductDto = ProductDto.toDto(updateProduct);

        return updateProductDto;
    }

    public void delete(Long id){
//        productRepository.delete(id);
        productMapper.delete(id);
    }
}
