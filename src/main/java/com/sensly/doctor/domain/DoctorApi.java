package com.sensly.doctor.domain;

import com.sensly.doctor.model.entity.Doctor;
import com.sensly.doctor.model.request.CreateDoctorRequest;
import com.sensly.doctor.model.response.CreateDoctorResponse;
import com.sensly.doctor.model.response.DoctorResponse;

import java.util.List;

public interface DoctorApi {

    CreateDoctorResponse create(CreateDoctorRequest request);

    List<DoctorResponse> findAll();

    Doctor findById(String doctorId);
}
