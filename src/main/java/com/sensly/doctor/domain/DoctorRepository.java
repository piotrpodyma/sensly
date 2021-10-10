package com.sensly.doctor.domain;

import com.sensly.doctor.model.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface DoctorRepository extends CrudRepository<Doctor, String> {

    List<Doctor> findAll();
}
