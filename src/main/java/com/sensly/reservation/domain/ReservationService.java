package com.sensly.reservation.domain;

import com.sensly.doctor.domain.DoctorApi;
import com.sensly.doctor.model.entity.Doctor;
import com.sensly.doctorCalendar.domain.DoctorCalendarApi;
import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import com.sensly.error.BusinessException;
import com.sensly.error.ErrorMessage;
import com.sensly.product.domain.ProductApi;
import com.sensly.product.model.Product;
import com.sensly.reservation.model.Reservation;
import com.sensly.reservation.model.ReservationRequest;
import com.sensly.reservation.model.ReservationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
class ReservationService {

    private final ProductApi productApi;
    private final DoctorApi doctorApi;
    private final DoctorCalendarApi doctorCalendarApi;
    private final ReservationRepository reservationRepository;

    @Transactional
    public ReservationResponse reservation(ReservationRequest request) {
        Doctor doctor = doctorApi.findById(request.getDoctorId());
        Product product = productApi.findById(request.getProductId());
        DoctorCalendar doctorCalendar = doctorCalendarApi.findById(request.getDoctorCalendarId());

        validation(doctor, doctorCalendar);

        Reservation reservation = createReservation(request, product, doctor, doctorCalendar);
        afterCreateReservation(reservation);
        reservationRepository.save(reservation);
        return new ReservationResponse(reservation.getId());
    }

    private void validation(Doctor doctor, DoctorCalendar doctorCalendar) {
        if (!doctorCalendar.getDoctor().equals(doctor)) {
            throw new BusinessException(ErrorMessage.DOCTOR_CALENDAR_NOT_MATCH_WITH_DOCTOR);
        }
        if (!doctorCalendar.isAvailable()) {
            throw new BusinessException(ErrorMessage.DOCTOR_CALENDAR_NOT_AVAILABLE);
        }
    }

    private void afterCreateReservation(Reservation reservation) {
        reservation.getDoctorCalendar().setAvailable(false);
    }

    private Reservation createReservation(ReservationRequest request, Product product, Doctor doctor, DoctorCalendar doctorCalendar) {
        Reservation reservation = new Reservation();
        reservation.setUserId(request.getUserId());
        reservation.setProduct(product);
        reservation.setDoctor(doctor);
        reservation.setDoctorCalendar(doctorCalendar);
        return reservation;
    }
}
