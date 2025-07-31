package com.backend.product_mgmt.domain;

import com.backend.product_mgmt.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void add(Product product);

    Product findById(@Param("id") Long id);

    List<Product> findAll();

    List<Product> findByNameContaining(@Param("name") String name);

    void update(Product product);

    void delete(@Param("id") Long id);
}
