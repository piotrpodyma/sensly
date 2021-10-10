package com.sensly.reservation.model;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class ReservationRequest {

    @NotBlank
    String userId;

    @NotBlank
    String doctorId;

    @NotBlank
    String productId;

    @NotBlank
    String doctorCalendarId;

}
