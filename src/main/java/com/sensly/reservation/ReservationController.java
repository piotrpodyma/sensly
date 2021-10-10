package com.sensly.reservation;

import com.sensly.reservation.domain.ReservationApi;
import com.sensly.reservation.model.ReservationRequest;
import com.sensly.reservation.model.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationApi reservationApi;

    @PostMapping("/api/reservation")
    public ResponseEntity<ReservationResponse> reservation(@RequestBody @Valid ReservationRequest request) {
        ReservationResponse reservationResponse = reservationApi.reservation(request);
        return ResponseEntity.ok(reservationResponse);
    }

}

