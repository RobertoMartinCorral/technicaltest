package com.kairos.technicalproof.utils.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@NoArgsConstructor
@Data
public class FindPriceResponse {

    private Long brandId;
    private Long productId;
    private Long priceListId;
    private Instant initialDate;
    private Instant finalDate;
    private BigDecimal amount;
}
