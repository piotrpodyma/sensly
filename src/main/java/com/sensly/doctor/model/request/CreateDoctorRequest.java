package com.sensly.doctor.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Data
public class CreateDoctorRequest {

    @NotBlank
    String doctorName;

}
