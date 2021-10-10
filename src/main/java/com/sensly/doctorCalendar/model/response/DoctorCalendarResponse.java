package com.sensly.doctorCalendar.model.response;

import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class DoctorCalendarResponse {

    String id;

    String doctorId;

    LocalDateTime dateTime;

    boolean available;

    public static DoctorCalendarResponse from(DoctorCalendar doctorCalendar) {
        return new DoctorCalendarResponse(
                doctorCalendar.getId(),
                doctorCalendar.getDoctor().getId(),
                doctorCalendar.getDateTime(),
                doctorCalendar.isAvailable());
    }

}
