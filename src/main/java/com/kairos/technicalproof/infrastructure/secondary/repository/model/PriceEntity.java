package com.kairos.technicalproof.infrastructure.secondary.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity(name="PRICES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEntity {

    @Id
    @Column(nullable=false, name="ID")
    private UUID id;

    @Column(nullable = false, name = "BRAND_ID")
    private Long brandId;

    @Column(nullable = false, name = "PRICE_LIST")
    private Long priceListId;

    @Column(nullable = false, name = "PRODUCT_ID")
    private Long productId;

    @Column(nullable = false, name = "PRIORITY")
    private Long priority;

    @Column(nullable = false, name = "PRICE")
    private BigDecimal price;

    @Column(nullable = false, name = "CURR")
    private String currency;

    @Column(nullable = false, name = "START_DATE")
    private Instant startDate;

    @Column(nullable = false, name = "END_DATE")
    private Instant endDate;
}