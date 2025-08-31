package com.prueba.bys.domain.ports.in.availability;

public interface DeleteAvailabilityUseCase {

    void deleteById(Long id);

    void logicalDeleteById(Long id);
}
