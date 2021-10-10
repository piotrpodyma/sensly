package com.sensly.reservation.domain;

import com.sensly.reservation.model.ReservationRequest;
import com.sensly.reservation.model.ReservationResponse;

public interface ReservationApi {

    ReservationResponse reservation(ReservationRequest request);
}
