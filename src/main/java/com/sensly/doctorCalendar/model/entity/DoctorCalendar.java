package com.sensly.doctorCalendar.model.entity;

import com.sensly.doctor.model.entity.Doctor;
import com.sensly.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class DoctorCalendar extends BaseEntity {

    @Column
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", foreignKey = @ForeignKey(name = "FK_doctor_calendar_doctor_id"))
    private Doctor doctor;

    @Column(nullable = false)
    private boolean available;
}
