package com.backend.product_mgmt.application;

import com.backend.product_mgmt.domain.Product;
import com.backend.product_mgmt.infrastructure.DatabaseProductRepository;
import com.backend.product_mgmt.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleProductService {
    private DatabaseProductRepository databaseProductRepository;
    private ModelMapper modelMapper;
    private ValidationService validationService;

    @Autowired
    SimpleProductService(DatabaseProductRepository databaseProductRepository, ModelMapper modelMapper, ValidationService validationService){
        this.databaseProductRepository = databaseProductRepository;
        this.modelMapper = modelMapper;
        this.validationService = validationService;
    }

    public ProductDto add(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        validationService.checkValid(product);

        Product savedProduct = databaseProductRepository.add(product);
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }

    public ProductDto findById(Long id){
        Product product = databaseProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);

        return productDto;
    }

    public List<ProductDto> findAll(){
        List<Product> products = databaseProductRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                    .map(product -> modelMapper.map(product, ProductDto.class))
                    .toList();

        return productDtos;
    }

    public List<ProductDto> findByNameContaining(String name){
        List<Product> products = databaseProductRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();

        return productDtos;
    }

    public ProductDto update(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        Product updateProduct = databaseProductRepository.update(product);
        ProductDto updateProductDto = modelMapper.map(updateProduct, ProductDto.class);

        return updateProductDto;
    }

    public void delete(Long id){
        databaseProductRepository.delete(id);
    }
}
