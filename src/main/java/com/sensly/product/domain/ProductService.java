package com.sensly.product.domain;

import com.sensly.doctor.domain.DoctorApi;
import com.sensly.doctor.model.entity.Doctor;
import com.sensly.error.BusinessException;
import com.sensly.error.ErrorMessage;
import com.sensly.product.model.CreateProductRequest;
import com.sensly.product.model.CreateProductResponse;
import com.sensly.product.model.Product;
import com.sensly.product.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class ProductService {

    private final ProductRepository productRepository;
    private final DoctorApi doctorApi;

    @Transactional(readOnly = true)
    public Product findById(String productId) {
        return productRepository.findById(productId).orElseThrow(() -> new BusinessException(ErrorMessage.PRODUCT_NOT_EXIST));
    }

    @Transactional
    public CreateProductResponse create(CreateProductRequest request) {
        Product product = createNewProduct(request);
        productRepository.save(product);
        return new CreateProductResponse(product.getId());
    }

    private Product createNewProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getProductName());
        Doctor doctor = doctorApi.findById(request.getDoctorId());
        product.setDoctor(doctor);
        product.setPrice(request.getProductPrice());
        return product;
    }

    public List<ProductResponse> findAllByDoctorId(String doctorId) {
        Doctor doctor = doctorApi.findById(doctorId);
        return productRepository.findAllByDoctor(doctor).stream()
                .map(ProductResponse::from)
                .collect(Collectors.toList());
    }

}
