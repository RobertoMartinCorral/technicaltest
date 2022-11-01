package com.kairos.technicalproof.infrastructure.primary.api;

import com.kairos.technicalproof.infrastructure.primary.api.exception.PriceNotFoundException;
import com.kairos.technicalproof.infrastructure.primary.api.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(PriceNotFoundException.class)
    public ErrorResponse handleException(PriceNotFoundException ex) {
        return new ErrorResponse(ex.getCode(),ex.getMessage());
    }
}
