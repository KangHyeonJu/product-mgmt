package com.backend.product_mgmt.presentation;

public class ProductDto {
    private Long id;

    private String name;

    private Integer price;

    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
