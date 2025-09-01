package com.prueba.bys.application.usecases.search;

import com.prueba.bys.domain.models.Search;
import com.prueba.bys.domain.ports.in.search.CreateSearchUseCase;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;
import com.prueba.bys.domain.services.SearchDomainService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateSearchUseCaseImpl implements CreateSearchUseCase {

    private final SearchRepositoryPort searchRepositoryPort;
    private final SearchDomainService searchDomainService;

    public CreateSearchUseCaseImpl(SearchRepositoryPort searchRepositoryPort){
        this.searchRepositoryPort = searchRepositoryPort;
        this.searchDomainService = new SearchDomainService(this.searchRepositoryPort);
    }

    @Transactional
    @Override
    public Search create(Search search) {
        Search newSearch = searchRepositoryPort.save(search);
        newSearch.setName(newSearch.generateName());
        searchDomainService.validateDuplicatedName(newSearch.getName());
        return searchRepositoryPort.save(newSearch);
    }

}
