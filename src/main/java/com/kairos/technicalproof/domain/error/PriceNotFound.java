package com.kairos.technicalproof.domain.error;

import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.ProductId;

import java.time.Instant;

public class PriceNotFound extends DomainError {
    public PriceNotFound(BrandId brandId, ProductId productId, Instant instant) {
        super("DOM-ERR0001", String.format("Price from brand %d and product %d at %s cannot be found", brandId.getId(), productId.getId(), instant.toString()), null);
    }
}
