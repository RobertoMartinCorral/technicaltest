package com.kairos.technicalproof.domain.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Price {
    private final Amount amount;
    private final ProductId product;
    private final BrandId brand;
    private final PriceSchedule schedule;
}
