package com.kairos.technicalproof.infrastructure.secondary.repository;

import com.kairos.technicalproof.application.usecases.ports.secondary.PricesRepositoryPort;
import com.kairos.technicalproof.domain.core.BrandId;
import com.kairos.technicalproof.domain.core.Price;
import com.kairos.technicalproof.domain.core.ProductId;
import com.kairos.technicalproof.domain.error.PriceNotFound;
import com.kairos.technicalproof.infrastructure.secondary.repository.jpa.PricesRepository;
import com.kairos.technicalproof.infrastructure.secondary.repository.mapper.PriceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PricesRepositoryAdapter implements PricesRepositoryPort {

    private final PricesRepository repository;
    private final PriceMapper priceMapper;
    private final Scheduler jdbcScheduler;

    @Override
    public Mono<Price> findPrice(BrandId brand, ProductId product, Instant instant) {

        return Mono.defer(() -> Mono.just(repository.findFirstByProductIdAndBrandIdAndDateOrderByPriorityDesc(
                                            product.getId(), brand.getId(), instant))
                                    .map(p -> priceMapper.mapToDomain(p))
                                    .switchIfEmpty(Mono.error(new PriceNotFound(brand, product, instant)))
                                    .subscribeOn(jdbcScheduler));
    }
}
