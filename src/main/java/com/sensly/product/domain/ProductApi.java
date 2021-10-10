package com.sensly.product.domain;

import com.sensly.product.model.CreateProductRequest;
import com.sensly.product.model.CreateProductResponse;
import com.sensly.product.model.Product;
import com.sensly.product.model.ProductResponse;

import java.util.List;

public interface ProductApi {

    CreateProductResponse create(CreateProductRequest request);

    List<ProductResponse> findAllByDoctorId(String doctorId);

    Product findById(String productId);
}
