package com.sensly.reservation.domain;

import com.sensly.reservation.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ReservationRepository extends CrudRepository<Reservation, String> {
}
