package com.kairos.technicalproof.infrastructure.secondary.repository.mapper;

public interface DomainMapper<D, E> {
    D mapToDomain(E infrastructure);
}
