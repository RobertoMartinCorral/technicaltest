package com.kairos.technicalproof.infrastructure.primary.api.price.mapper;

import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.infrastructure.primary.api.model.price.FindPriceResponse;

public class FindPriceMapper {

    public static FindPriceResponse mapToResponse(Price price) {
        return new FindPriceResponse(
                price.getBrand().getId(),
                price.getProduct().getId(),
                price.getPriceList().getId(),
                price.getSchedule().getInitialDate(),
                price.getSchedule().getFinalDate(),
                price.getAmount().getValue()
        );
    }

}
