package com.sensly.error;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel
@Getter
public enum ErrorMessage {

    VALIDATION_FAILED,
    DOCTOR_CALENDAR_NOT_EXIST,
    PRODUCT_NOT_EXIST,
    DOCTOR_NOT_EXIST,
    DOCTOR_CALENDAR_NOT_MATCH_WITH_DOCTOR,
    DOCTOR_CALENDAR_NOT_AVAILABLE

}
