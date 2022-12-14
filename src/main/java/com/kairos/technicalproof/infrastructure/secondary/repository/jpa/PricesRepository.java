package com.kairos.technicalproof.infrastructure.secondary.repository.jpa;

import com.kairos.technicalproof.infrastructure.secondary.repository.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.UUID;

public interface PricesRepository extends JpaRepository<PriceEntity, UUID> {

    @Query(value = "SELECT * FROM PRICES WHERE PRODUCT_ID=?1 AND BRAND_ID=?2 AND START_DATE <= ?3 AND END_DATE >= ?3 ORDER BY PRIORITY DESC LIMIT 1", nativeQuery = true)
    PriceEntity findFirstByProductIdAndBrandIdAndDateOrderByPriorityDesc(Long productId, Long brandId, Instant date);
}
