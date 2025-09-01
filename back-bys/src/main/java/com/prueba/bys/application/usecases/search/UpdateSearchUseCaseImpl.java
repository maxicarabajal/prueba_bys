package com.prueba.bys.application.usecases.search;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Search;
import com.prueba.bys.domain.ports.in.search.UpdateSearchUseCase;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;
import com.prueba.bys.domain.services.SearchDomainService;
import org.springframework.stereotype.Service;

@Service
public class UpdateSearchUseCaseImpl implements UpdateSearchUseCase {

    private final SearchRepositoryPort searchRepositoryPort;
    private final SearchDomainService searchDomainService;

    public UpdateSearchUseCaseImpl(SearchRepositoryPort searchRepositoryPort){
        this.searchRepositoryPort = searchRepositoryPort;
        this.searchDomainService = new SearchDomainService(this.searchRepositoryPort);
    }

    @Override
    public Search update(Search search) {
        Search searchPersisted = searchRepositoryPort.findById(search.getId());
        return searchRepositoryPort.save(searchPersisted);
    }
}
