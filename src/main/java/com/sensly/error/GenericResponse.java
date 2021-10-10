package com.sensly.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;

@Value
public class GenericResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    ErrorMessage error;

    public static GenericResponse error(final ErrorMessage error) {
        return new GenericResponse(error);
    }

}