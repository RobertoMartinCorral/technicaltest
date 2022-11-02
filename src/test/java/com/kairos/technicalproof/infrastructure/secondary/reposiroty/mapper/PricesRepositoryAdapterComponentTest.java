package com.kairos.technicalproof.infrastructure.secondary.reposiroty.mapper;

import com.github.michaelbull.result.Result;
import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.DomainError;
import com.kairos.technicalproof.domain.error.PriceNotFound;
import com.kairos.technicalproof.infrastructure.secondary.repository.PricesRepositoryAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PricesRepositoryAdapterComponentTest {

    @Autowired
    private PricesRepositoryAdapter pricesRepositoryAdapter;

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At10() {

        Result<Price, DomainError> result = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-14T10:00:00Z"));
        assertEquals(result.component1().getAmount().getValue(), new BigDecimal("35.50"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At16() {

        Result<Price, DomainError> result = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-14T16:00:00Z"));
        assertEquals(result.component1().getAmount().getValue(), new BigDecimal("25.45"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune14th2020At21() {

        Result<Price, DomainError> result = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-14T21:00:00Z"));
        assertEquals(result.component1().getAmount().getValue(), new BigDecimal("35.50"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune15th2020At10() {

        Result<Price, DomainError> result = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-15T10:00:00Z"));
        assertEquals(result.component1().getAmount().getValue(), new BigDecimal("30.50"));
    }

    @Test
    public void shouldReturnPriceWhenSearchingOnJune16th2020At21() {

        Result<Price, DomainError> result = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2020-06-16T21:00:00Z"));
        assertEquals(result.component1().getAmount().getValue(), new BigDecimal("38.95"));
    }

    @Test
    public void mustReturnPriceNotFoundWhenNoPriceIsFounded() {

        Result<Price, DomainError> result = pricesRepositoryAdapter.findPrice(new BrandId(1L), new ProductId(35455L), Instant.parse("2022-06-16T21:00:00Z"));
        assertNull(result.component1());
        assertEquals(result.component2().getClass(), PriceNotFound.class);
    }
}
