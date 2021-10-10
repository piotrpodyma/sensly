package com.sensly.doctorCalendar.domain;

import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import com.sensly.doctorCalendar.model.request.CreateDoctorCalendarRequest;
import com.sensly.doctorCalendar.model.response.CreateDoctorCalendarResponse;
import com.sensly.doctorCalendar.model.response.DoctorCalendarResponse;

import java.util.List;

public interface DoctorCalendarApi {

    CreateDoctorCalendarResponse create(CreateDoctorCalendarRequest request);

    List<DoctorCalendarResponse> findByDoctor(String doctorId);

    DoctorCalendar findById(String doctorCalendarId);
}
