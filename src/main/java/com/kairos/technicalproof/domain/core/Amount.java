package com.kairos.technicalproof.domain.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Getter
public class Amount {
    private final BigDecimal value;
    private final String currency;
}
