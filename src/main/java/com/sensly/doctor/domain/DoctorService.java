package com.sensly.doctor.domain;

import com.sensly.doctor.model.entity.Doctor;
import com.sensly.doctor.model.request.CreateDoctorRequest;
import com.sensly.doctor.model.response.CreateDoctorResponse;
import com.sensly.doctor.model.response.DoctorResponse;
import com.sensly.error.BusinessException;
import com.sensly.error.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class DoctorService {

    private final DoctorRepository doctorRepository;

    @Transactional(readOnly = true)
    public Doctor findById(String doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new BusinessException(ErrorMessage.DOCTOR_NOT_EXIST));
    }

    @Transactional
    public CreateDoctorResponse create(CreateDoctorRequest request) {
        final Doctor doctor = createDoctor(request);
        doctorRepository.save(doctor);

        return new CreateDoctorResponse(doctor.getId());
    }

    private Doctor createDoctor(CreateDoctorRequest request) {
        final var doctor = new Doctor();
        doctor.setDoctorName(request.getDoctorName());
        return doctor;
    }

    @Transactional(readOnly = true)
    public List<DoctorResponse> findAll() {
        return doctorRepository.findAll().stream()
                .map(DoctorResponse::from)
                .collect(Collectors.toList());
    }
}
