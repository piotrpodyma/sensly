package com.sensly.reservation.domain;

import com.sensly.reservation.model.ReservationRequest;
import com.sensly.reservation.model.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ReservationDomain implements ReservationApi {

    private final ReservationService reservationService;

    @Override
    public ReservationResponse reservation(ReservationRequest request) {
        return reservationService.reservation(request);
    }
}
