package com.sensly.doctor.domain;

import com.sensly.doctor.model.entity.Doctor;
import com.sensly.doctor.model.request.CreateDoctorRequest;
import com.sensly.doctor.model.response.CreateDoctorResponse;
import com.sensly.doctor.model.response.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class DoctorDomain implements DoctorApi {

    private final DoctorService doctorService;

    @Override
    public CreateDoctorResponse create(CreateDoctorRequest request) {
        return doctorService.create(request);
    }

    @Override
    public List<DoctorResponse> findAll() {
        return doctorService.findAll();
    }

    @Override
    public Doctor findById(String doctorId) {
        return doctorService.findById(doctorId);
    }
}
