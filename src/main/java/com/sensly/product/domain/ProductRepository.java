package com.sensly.product.domain;

import com.sensly.doctor.model.entity.Doctor;
import com.sensly.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ProductRepository extends CrudRepository<Product, String> {

    List<Product> findAllByDoctor(Doctor doctor);
}
