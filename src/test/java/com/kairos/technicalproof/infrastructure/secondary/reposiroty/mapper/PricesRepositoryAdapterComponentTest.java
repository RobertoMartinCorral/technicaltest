package com.kairos.technicalproof.infrastructure.secondary.reposiroty.mapper;

import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.PriceNotFound;
import com.kairos.technicalproof.infrastructure.primary.api.exception.PriceNotFoundException;
import com.kairos.technicalproof.infrastructure.secondary.repository.PricesRepositoryAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PricesRepositoryAdapterComponentTest {

    @Autowired
    private PricesRepositoryAdapter pricesRepositoryAdapter;

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At10() {

        Mono<Price> mono = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-14T10:00:00Z"));
        Price result = mono.block();
        assertEquals(result.getAmount().getValue(), new BigDecimal("35.50"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At16() {

        Mono<Price> mono = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-14T16:00:00Z"));
        Price result = mono.block();
        assertEquals(result.getAmount().getValue(), new BigDecimal("25.45"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At21() {

        Mono<Price> mono = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-14T21:00:00Z"));
        Price result = mono.block();
        assertEquals(result.getAmount().getValue(), new BigDecimal("35.50"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune15th2020At10() {

        Mono<Price> mono = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-15T10:00:00Z"));
        Price result = mono.block();
        assertEquals(result.getAmount().getValue(), new BigDecimal("30.50"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune16th2020At21() {

        Mono<Price> mono = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-16T21:00:00Z"));
        Price result = mono.block();
        assertEquals(result.getAmount().getValue(), new BigDecimal("38.95"));
    }

    @Test
    public void mustReturnPriceNotFoundWhenNoPriceIsFounded() {

        assertThrows( PriceNotFound.class, () -> {pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2022-06-16T21:00:00Z")).block();});
    }
}
