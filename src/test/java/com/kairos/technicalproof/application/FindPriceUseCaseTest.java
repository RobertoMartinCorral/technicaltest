package com.kairos.technicalproof.application;

import com.github.michaelbull.result.Err;
import com.github.michaelbull.result.Ok;
import com.github.michaelbull.result.Result;
import com.kairos.technicalproof.application.usecases.FindPriceUseCase;
import com.kairos.technicalproof.application.usecases.ports.secondary.PricesRepositoryPort;
import com.kairos.technicalproof.domain.core.*;
import com.kairos.technicalproof.domain.error.DomainError;
import com.kairos.technicalproof.domain.error.PriceNotFound;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class FindPriceUseCaseTest {

    @Mock
    private PricesRepositoryPort pricesRepository;

    @InjectMocks
    private FindPriceUseCase findPriceUseCase;

    @Test
    public void priceIsFindedWhenConditionsApply() {
        // GIVEN
        Price returnedPrice =
                new Price (
                        new Amount(new BigDecimal("1.0"), "EUR"),
                        new ProductId(1L),
                        new BrandId(1L),
                        new PriceSchedule(
                                Instant.now(),
                                Instant.now().plus(5L, ChronoUnit.DAYS)),
                        new PriceListId(1L)
                );
        org.mockito.Mockito.when(pricesRepository.findPrice(any(BrandId.class), any(ProductId.class), any(Instant.class)))
                           .thenReturn(new Ok(returnedPrice));

        // WHEN
        Result<Price, DomainError> result = findPriceUseCase.findPrice(new BrandId(1L), new ProductId(1L), Instant.now());

        // THEN
        assertInstanceOf(Price.class,result.component1());
        assertEquals(result.component1(), returnedPrice);
        assertNull(result.component2());
    }

    @Test()
    public void failsWhenNoPriceIsFinded() {
        // GIVEN
        PriceNotFound domainErrorReturned =  new PriceNotFound(new BrandId(1L), new ProductId(1L), Instant.now());
        org.mockito.Mockito.when(pricesRepository.findPrice(any(BrandId.class), any(ProductId.class), any(Instant.class)))
                           .thenReturn(new Err<DomainError>(domainErrorReturned));

        // WHEN
        Result<Price, DomainError> result = findPriceUseCase.findPrice(new BrandId(1L), new ProductId(1L), Instant.now());

        // THEN
        assertInstanceOf(PriceNotFound.class,result.component2());
        assertEquals(result.component2(), domainErrorReturned);
        assertNull(result.component1());
    }
}
