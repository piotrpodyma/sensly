package com.sensly.doctor.model.response;

import com.sensly.doctor.model.entity.Doctor;
import lombok.Value;

@Value
public class DoctorResponse {

    String id;
    String name;

    public static DoctorResponse from(Doctor doctor) {
        return new DoctorResponse(doctor.getId(),
                doctor.getDoctorName());
    }
}
