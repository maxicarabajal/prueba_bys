package com.prueba.bys.application.usecases.search;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Search;
import com.prueba.bys.domain.ports.in.search.UpdateSearchUseCase;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateSearchUseCaseImpl implements UpdateSearchUseCase {

    private final SearchRepositoryPort searchRepositoryPort;

    public UpdateSearchUseCaseImpl(SearchRepositoryPort searchRepositoryPort){
        this.searchRepositoryPort = searchRepositoryPort;
    }

    @Override
    public Search update(Search search) {
        if(search.getId() == null) throw new NotFoundException("no se encontro la busqueda con id: "+search.getId());
        return searchRepositoryPort.save(search);
    }
}
