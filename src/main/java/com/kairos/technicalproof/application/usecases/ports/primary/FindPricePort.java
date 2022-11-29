package com.kairos.technicalproof.application.usecases.ports.primary;

import com.github.michaelbull.result.Result;
import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.DomainError;
import reactor.core.publisher.Mono;

import java.time.Instant;

public interface FindPricePort {

    Mono<Price> findPrice(BrandId brandID, ProductId productId, Instant instant);
}
