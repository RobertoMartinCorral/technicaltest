package com.kairos.technicalproof.infrastructure.primary.api.model.price;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor
@Getter
public class FindPriceResponse {
    private final Long brandId;
    private final Long productId;
    private final Long priceListId;
    private final Instant initialDate;
    private final Instant finalDate;
    private final Double amount;
}
