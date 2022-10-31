package com.kairos.technicalproof.domain.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Amount {
    private final Double value;
    private final String currency;
}
