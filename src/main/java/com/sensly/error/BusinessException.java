package com.sensly.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorMessage error;
    private final HttpStatus httpStatus;

    public BusinessException(final ErrorMessage error) {
        super(error.name());
        this.error = error;
        this.httpStatus = HttpStatus.CONFLICT;
    }

}
