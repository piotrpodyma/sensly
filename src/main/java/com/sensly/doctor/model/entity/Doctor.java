package com.sensly.doctor.model.entity;

import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import com.sensly.shared.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@Entity
public class Doctor extends BaseEntity {

    @Column
    private String doctorName;

    @OneToMany(mappedBy = "doctor", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<DoctorCalendar> doctorCalendar;
}
