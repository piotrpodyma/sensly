package com.sensly.doctor;

import com.sensly.doctor.domain.DoctorApi;
import com.sensly.doctor.model.request.CreateDoctorRequest;
import com.sensly.doctor.model.response.CreateDoctorResponse;
import com.sensly.doctor.model.response.DoctorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorApi doctorApi;

    @PostMapping("/api/doctors")
    public ResponseEntity<CreateDoctorResponse> create(@RequestBody @Valid CreateDoctorRequest request) {
        CreateDoctorResponse createDoctorResponse = doctorApi.create(request);
        return ResponseEntity.ok(createDoctorResponse);
    }

    @GetMapping("/api/doctors")
    public List<DoctorResponse> findAll() {
        return doctorApi.findAll();
    }
}
