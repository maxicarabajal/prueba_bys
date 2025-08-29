package com.prueba.bys.domain.services;

import com.prueba.bys.domain.exceptions.DuplicatedNameException;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;

public class HiringModalityDomainService {
    private final HiringModalityRepositoryPort repositoryPort;

    public HiringModalityDomainService(HiringModalityRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public void validateDuplicatedName(String name) {
        if (repositoryPort.existsByName(name)) {
            throw new DuplicatedNameException("Modalidad de contratación ya registrada.");
        }
    }
}
