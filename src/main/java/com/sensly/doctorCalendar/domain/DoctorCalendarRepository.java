package com.sensly.doctorCalendar.domain;

import com.sensly.doctorCalendar.model.entity.DoctorCalendar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface DoctorCalendarRepository extends CrudRepository<DoctorCalendar, String> {

    List<DoctorCalendar> findByDoctorId(String doctorId);
}
