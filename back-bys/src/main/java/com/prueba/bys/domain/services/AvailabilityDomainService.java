package com.prueba.bys.domain.services;

import com.prueba.bys.domain.exceptions.DuplicatedNameException;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;

public class AvailabilityDomainService {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;

    public AvailabilityDomainService(AvailabilityRepositoryPort availabilityRepositoryPort) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
    }

    public void validateDuplicatedName(String name) {
        if (availabilityRepositoryPort.existByName(name)) {
            throw new DuplicatedNameException("Disponibilidad ya registrada.");
        }
    }
}
