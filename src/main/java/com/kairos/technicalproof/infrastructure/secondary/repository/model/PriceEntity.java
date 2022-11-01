package com.kairos.technicalproof.infrastructure.secondary.repository.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.Instant;

@Entity(name="PRICES")
@RequiredArgsConstructor
@Getter
@IdClass(PriceEntityId.class)
public class PriceEntity {

    @Id
    @Column(nullable = false, name = "BRAND_ID")
    private final Long brandId;

    @Id
    @Column(nullable = false, name = "PRICE_LIST")
    private final Long priceListId;

    @Id
    @Column(nullable = false, name = "PRODUCT_ID")
    private final Long productId;

    @Id
    @Column(nullable = false, name = "PRIORITY")
    private final Long priority;

    @Column(nullable = false, name = "PRICE")
    private final Double price;

    @Column(nullable = false, name = "CURR")
    private final String currency;

    @Column(nullable = false, name = "START_DATE")
    private final Instant startDate;

    @Column(nullable = false, name = "END_DATE")
    private final Instant endDate;
}