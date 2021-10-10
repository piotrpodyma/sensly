package com.sensly.doctorCalendar.model.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Value
public class CreateDoctorCalendarRequest {

    @NotBlank
    String doctorId;

    @NotNull
    LocalDateTime dateTime;
}
