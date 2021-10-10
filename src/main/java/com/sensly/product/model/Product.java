package com.sensly.product.model;

import com.sensly.shared.BaseEntity;
import com.sensly.doctor.model.entity.Doctor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Product extends BaseEntity {

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", foreignKey = @ForeignKey(name = "FK_product_doctor_id"))
    private Doctor doctor;

    private BigDecimal price;
}
