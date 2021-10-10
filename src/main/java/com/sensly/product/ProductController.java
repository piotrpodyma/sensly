package com.sensly.product;

import com.sensly.product.domain.ProductApi;
import com.sensly.product.model.CreateProductRequest;
import com.sensly.product.model.CreateProductResponse;
import com.sensly.product.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductApi productApi;

    @PostMapping("/api/products")
    public ResponseEntity<CreateProductResponse> create(@RequestBody @Valid CreateProductRequest request) {
        CreateProductResponse createProductResponse = productApi.create(request);
        return ResponseEntity.ok(createProductResponse);
    }

    @GetMapping("/api/doctor/{doctorId}/products")
    public List<ProductResponse> getAllForDoctor(@PathVariable String doctorId) {
        return productApi.findAllByDoctorId(doctorId);
    }
}
