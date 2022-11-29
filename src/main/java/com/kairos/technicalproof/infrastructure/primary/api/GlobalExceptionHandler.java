package com.kairos.technicalproof.infrastructure.primary.api;

import com.kairos.technicalproof.infrastructure.primary.api.exception.PriceNotFoundException;
import com.kairos.technicalproof.infrastructure.primary.api.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity handleException(PriceNotFoundException ex) {
        return ResponseEntity.of(Optional.of(new ErrorResponse(ex.getCode(),ex.getMessage())));
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.notFound().build();
    }
}
