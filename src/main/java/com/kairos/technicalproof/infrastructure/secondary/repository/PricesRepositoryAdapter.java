package com.kairos.technicalproof.infrastructure.secondary.repository;

import com.github.michaelbull.result.Err;
import com.github.michaelbull.result.Ok;
import com.github.michaelbull.result.Result;
import com.kairos.technicalproof.application.usecases.ports.secondary.PricesRepositoryPort;
import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.DomainError;
import com.kairos.technicalproof.domain.error.PriceNotFound;
import com.kairos.technicalproof.infrastructure.secondary.repository.jpa.PricesRepository;
import com.kairos.technicalproof.infrastructure.secondary.repository.mapper.PriceMapper;
import com.kairos.technicalproof.infrastructure.secondary.repository.model.PriceEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PricesRepositoryAdapter implements PricesRepositoryPort {

    private final PricesRepository repository;
    private final PriceMapper priceMapper;

    @Override
    public Result<Price, DomainError> findPrice(BrandId brand, ProductId product, Instant instant) {

        PriceEntity entity = repository.findFirstByProductIdAndBrandIdAndDateOrderByPriorityDesc(
                product.getId(), brand.getId(), instant);

        if (entity != null) {
            return new Ok(priceMapper.mapToDomain(entity));
        } else {
            return new Err(new PriceNotFound(brand, product, instant));
        }
    }

}
