package com.sensly.product.model;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductResponse {

    String id;
    String name;
    BigDecimal price;

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice());
    }
}
