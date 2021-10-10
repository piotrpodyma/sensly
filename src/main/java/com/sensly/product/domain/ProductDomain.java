package com.sensly.product.domain;

import com.sensly.product.model.CreateProductRequest;
import com.sensly.product.model.CreateProductResponse;
import com.sensly.product.model.Product;
import com.sensly.product.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class ProductDomain implements ProductApi {

    private final ProductService productService;

    @Override
    public CreateProductResponse create(CreateProductRequest request) {
        return productService.create(request);
    }

    @Override
    public List<ProductResponse> findAllByDoctorId(String doctorId) {
        return productService.findAllByDoctorId(doctorId);
    }

    @Override
    public Product findById(String productId) {
        return productService.findById(productId);
    }
}
