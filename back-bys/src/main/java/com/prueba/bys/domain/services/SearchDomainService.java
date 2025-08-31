package com.prueba.bys.domain.services;

import com.prueba.bys.domain.exceptions.DuplicatedNameException;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;

public class SearchDomainService {
    private final SearchRepositoryPort repositoryPort;

    public SearchDomainService(SearchRepositoryPort repositoryPort){
        this.repositoryPort = repositoryPort;
    }

    public void validateDuplicatedName(String name) {
        if (repositoryPort.existsName(name)) {
            throw new DuplicatedNameException("El nombre de la busqueda ya se encuentra en uso.");
        }
    }

}
