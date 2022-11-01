package com.kairos.technicalproof.infrastructure.secondary.repository.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PriceEntityId {

    private final Long brandId;

    private final Long priceListId;

    private final Long productId;

    private final Long priority;

}
