package com.kairos.technicalproof.application.usecases.ports.secondary;

import com.github.michaelbull.result.Result;
import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.DomainError;

import java.time.Instant;

public interface PricesRepositoryPort {
    Result<Price, DomainError> findPrice(BrandId brand, ProductId product, Instant instant);
}
