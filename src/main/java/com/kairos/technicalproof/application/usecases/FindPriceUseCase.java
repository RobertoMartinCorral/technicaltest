package com.kairos.technicalproof.application.usecases;

import com.github.michaelbull.result.Result;
import com.kairos.technicalproof.application.usecases.ports.primary.FindPricePort;
import com.kairos.technicalproof.application.usecases.ports.secondary.PricesRepositoryPort;
import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.DomainError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindPriceUseCase implements FindPricePort {

    private final PricesRepositoryPort pricesRepositoryPort;

    public Result<Price, DomainError> findPrice(BrandId brandID, ProductId productId, Instant instant) {
        return pricesRepositoryPort.findPrice(brandID, productId, instant);
    }
}
