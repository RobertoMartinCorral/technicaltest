package com.kairos.technicalproof.domain.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class PriceSchedule {

    private final Instant initialDate;
    private final Instant finalDate;
}
