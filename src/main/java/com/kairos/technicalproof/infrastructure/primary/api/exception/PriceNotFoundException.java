package com.kairos.technicalproof.infrastructure.primary.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PriceNotFoundException extends Exception {

    private final String code;

    public PriceNotFoundException(String code,String message) {
        super (message);
        this.code = code;
    }
}
