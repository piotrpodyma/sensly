package com.sensly.reservation.model;

import com.sensly.doctor.model.entity.Doctor;
import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import com.sensly.product.model.Product;
import com.sensly.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Reservation extends BaseEntity {

    @Column
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false, foreignKey = @ForeignKey(name = "FK_reservation_doctor_id"))
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "FK_reservation_product_id"))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_calendar_id", nullable = false, foreignKey = @ForeignKey(name = "FK_reservation_doctor_calendar_id"))
    private DoctorCalendar doctorCalendar;

}
