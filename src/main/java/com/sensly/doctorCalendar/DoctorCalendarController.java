package com.sensly.doctorCalendar;

import com.sensly.doctorCalendar.domain.DoctorCalendarApi;
import com.sensly.doctorCalendar.model.request.CreateDoctorCalendarRequest;
import com.sensly.doctorCalendar.model.response.CreateDoctorCalendarResponse;
import com.sensly.doctorCalendar.model.response.DoctorCalendarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorCalendarController {

    private final DoctorCalendarApi doctorCalendarApi;

    @PostMapping("/api/doctor-calendars")
    public ResponseEntity<CreateDoctorCalendarResponse> create(@RequestBody @Valid CreateDoctorCalendarRequest request) {
        CreateDoctorCalendarResponse createDoctorCalendarResponse = doctorCalendarApi.create(request);
        return ResponseEntity.ok(createDoctorCalendarResponse);
    }

    @GetMapping("/api/doctor/{doctorId}/doctor-calendars")
    public List<DoctorCalendarResponse> findByDoctor(@PathVariable String doctorId) {
        return doctorCalendarApi.findByDoctor(doctorId);
    }

}
