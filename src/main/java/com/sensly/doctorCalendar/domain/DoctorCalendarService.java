package com.sensly.doctorCalendar.domain;

import com.sensly.doctor.domain.DoctorApi;
import com.sensly.doctor.model.entity.Doctor;
import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import com.sensly.doctorCalendar.model.request.CreateDoctorCalendarRequest;
import com.sensly.doctorCalendar.model.response.CreateDoctorCalendarResponse;
import com.sensly.doctorCalendar.model.response.DoctorCalendarResponse;
import com.sensly.error.BusinessException;
import com.sensly.error.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class DoctorCalendarService {

    private final DoctorCalendarRepository doctorCalendarRepository;
    private final DoctorApi doctorApi;

    public DoctorCalendar findById(String doctorCalendarId) {
        return doctorCalendarRepository.findById(doctorCalendarId).orElseThrow(() -> new BusinessException(ErrorMessage.DOCTOR_CALENDAR_NOT_EXIST));
    }

    @Transactional
    public CreateDoctorCalendarResponse create(CreateDoctorCalendarRequest request) {
        DoctorCalendar doctorCalendar = createDoctorCalendar(request);
        doctorCalendarRepository.save(doctorCalendar);
        return new CreateDoctorCalendarResponse(doctorCalendar.getId());
    }

    private DoctorCalendar createDoctorCalendar(CreateDoctorCalendarRequest request) {
        DoctorCalendar doctorCalendar = new DoctorCalendar();
        Doctor doctor = doctorApi.findById(request.getDoctorId());
        doctorCalendar.setDoctor(doctor);
        doctorCalendar.setAvailable(true);
        doctorCalendar.setDateTime(request.getDateTime());
        return doctorCalendar;
    }

    public List<DoctorCalendarResponse> findByDoctor(String doctorId) {
        return doctorCalendarRepository.findByDoctorId(doctorId).stream()
                .map(DoctorCalendarResponse::from)
                .collect(Collectors.toList());
    }

}
