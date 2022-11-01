package com.kairos.technicalproof.infrastructure.secondary.repository.mapper;

import com.kairos.technicalproof.domain.core.*;
import com.kairos.technicalproof.infrastructure.secondary.repository.model.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper implements DomainMapper<Price, PriceEntity> {

    @Override
    public Price mapToDomain(PriceEntity infrastructure) {
        return new Price(
                new Amount(infrastructure.getPrice(), infrastructure.getCurrency()),
                new ProductId(infrastructure.getProductId()),
                new BrandId(infrastructure.getBrandId()),
                new PriceSchedule(infrastructure.getStartDate(), infrastructure.getEndDate()),
                new PriceListId(infrastructure.getPriceListId())
        );
    }
}