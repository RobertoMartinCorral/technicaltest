package com.kairos.technicalproof.infrastructure.primary.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {
    private final String code;
    private final String message;
}
