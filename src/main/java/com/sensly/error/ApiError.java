package com.sensly.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Value
class ApiError {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    ErrorMessage error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    LocalDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<ObjectError> errors;

}
