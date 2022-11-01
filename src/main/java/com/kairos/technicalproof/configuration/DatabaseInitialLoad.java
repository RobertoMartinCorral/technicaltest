package com.kairos.technicalproof.configuration;

import com.kairos.technicalproof.infrastructure.secondary.repository.jpa.PricesRepository;
import com.kairos.technicalproof.infrastructure.secondary.repository.model.PriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DatabaseInitialLoad {

    private final PricesRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void initializePrices() {
        repository.save(priceEntityFactory(1L, 1L, 35455L, 0L, new BigDecimal("35.50"), "2020-06-14T00:00:00Z", "2020-12-31T23:59:59Z"));
        repository.save(priceEntityFactory(1L, 2L, 35455L, 1L, new BigDecimal("25.45"), "2020-06-14T15:00:00Z", "2020-06-14T18:30:00Z"));
        repository.save(priceEntityFactory(1L, 3L, 35455L, 1L, new BigDecimal("30.50"), "2020-06-15T00:00:00Z", "2020-06-15T11:00:00Z"));
        repository.save(priceEntityFactory(1L, 4L, 35455L, 1L, new BigDecimal("38.95"), "2020-06-15T16:00:00Z", "2020-12-31T23:59:59Z"));
    }

    private PriceEntity priceEntityFactory(Long brandId, Long priceListId, Long productId, Long priority, BigDecimal price, String startDate, String endDate) {
        return new PriceEntity (
                UUID.randomUUID(),
                brandId,
                priceListId,
                productId,
                priority,
                price,
                "EUR",
                Instant.parse(startDate),
                Instant.parse(endDate));
    }
}
