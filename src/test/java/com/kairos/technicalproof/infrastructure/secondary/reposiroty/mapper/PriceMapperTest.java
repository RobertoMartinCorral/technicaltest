package com.kairos.technicalproof.infrastructure.secondary.reposiroty.mapper;

import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.infrastructure.secondary.repository.mapper.PriceMapper;
import com.kairos.technicalproof.infrastructure.secondary.repository.model.PriceEntity;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceMapperTest {

    @Test
    public void mustMapToDomain() {

        PriceEntity entity = new PriceEntity(
                UUID.randomUUID(),
                1L,
                2L,
                3L,
                4L,
                12.23,
                "EUR",
                Instant.now(),
                Instant.now().plus(5, ChronoUnit.DAYS)
        );

        Price mappedPrice = new PriceMapper().mapToDomain(entity);

        assertEquals(mappedPrice.getBrand().getId(), entity.getBrandId());
        assertEquals(mappedPrice.getProduct().getId(), entity.getProductId());
        assertEquals(mappedPrice.getPriceList().getId(), entity.getPriceListId());
        assertEquals(mappedPrice.getAmount().getValue(), entity.getPrice());
        assertEquals(mappedPrice.getAmount().getCurrency(), entity.getCurrency());
        assertEquals(mappedPrice.getSchedule().getInitialDate(), entity.getStartDate());
        assertEquals(mappedPrice.getSchedule().getFinalDate(), entity.getEndDate());

    }

}
