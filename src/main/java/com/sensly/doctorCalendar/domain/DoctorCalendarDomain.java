package com.sensly.doctorCalendar.domain;

import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import com.sensly.doctorCalendar.model.request.CreateDoctorCalendarRequest;
import com.sensly.doctorCalendar.model.response.CreateDoctorCalendarResponse;
import com.sensly.doctorCalendar.model.response.DoctorCalendarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class DoctorCalendarDomain implements DoctorCalendarApi {

    private final DoctorCalendarService doctorCalendarService;

    @Override
    public CreateDoctorCalendarResponse create(CreateDoctorCalendarRequest request) {
        return doctorCalendarService.create(request);
    }

    @Override
    public List<DoctorCalendarResponse> findByDoctor(String doctorId) {
        return doctorCalendarService.findByDoctor(doctorId);
    }

    @Override
    public DoctorCalendar findById(String doctorCalendarId) {
        return doctorCalendarService.findById(doctorCalendarId);
    }
}
