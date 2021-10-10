package com.sensly.product.model;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
public class CreateProductRequest {

    @NotBlank
    String productName;

    @NotBlank
    String doctorId;

    @NotNull
    BigDecimal productPrice;
}
