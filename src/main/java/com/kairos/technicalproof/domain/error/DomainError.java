package com.kairos.technicalproof.domain.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class DomainError {

    private final String code;
    private final String message;
    private final Exception cause;
}

