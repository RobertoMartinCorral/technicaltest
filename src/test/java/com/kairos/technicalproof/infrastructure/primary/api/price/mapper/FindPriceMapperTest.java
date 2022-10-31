package com.kairos.technicalproof.infrastructure.primary.api.price.mapper;

import com.kairos.technicalproof.domain.core.*;
import com.kairos.technicalproof.infrastructure.primary.api.model.price.FindPriceResponse;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPriceMapperTest {

    @Test
    public void mustMapToResponseFromDomain() {
        Price price = new Price(
                new Amount(12.5, "EUR"),
                new ProductId(2L),
                new BrandId(3L),
                new PriceSchedule(Instant.now(), Instant.now().plus(5, ChronoUnit.DAYS)),
                new PriceListId(1L)
        );
        FindPriceResponse findPriceResponse = FindPriceMapper.mapToResponse(price);

        assertEquals(price.getAmount().getValue(), findPriceResponse.getAmount());
        assertEquals(price.getProduct().getId(), findPriceResponse.getProductId());
        assertEquals(price.getBrand().getId(), findPriceResponse.getBrandId());
        assertEquals(price.getSchedule().getInitialDate(), findPriceResponse.getInitialDate());
        assertEquals(price.getSchedule().getFinalDate(), findPriceResponse.getFinalDate());
        assertEquals(price.getPriceList().getId(), findPriceResponse.getPriceListId());
    }
}
