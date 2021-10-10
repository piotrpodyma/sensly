package com.sensly.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    protected ResponseEntity<GenericResponse> handleBusinessException(final RuntimeException exception, final WebRequest request) {

        log.error(exception.getMessage(), exception);

        final var businessException = (BusinessException) exception;
        final var response = GenericResponse.error(businessException.getError());

        return ResponseEntity.status(businessException.getHttpStatus()).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        if (log.isDebugEnabled()) {
            log.debug(ex.getMessage());
        }

        final var error = ApiError.builder()
                .error(ErrorMessage.VALIDATION_FAILED)
                .errorMessage("Validation failed.")
                .errors(ex.getAllErrors())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}

