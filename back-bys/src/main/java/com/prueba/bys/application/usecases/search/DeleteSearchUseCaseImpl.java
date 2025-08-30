package com.prueba.bys.application.usecases.search;

import com.prueba.bys.domain.ports.in.search.DeleteSearchUseCase;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteSearchUseCaseImpl implements DeleteSearchUseCase {

    private final SearchRepositoryPort searchRepositoryPort;

    public DeleteSearchUseCaseImpl(SearchRepositoryPort searchRepositoryPort){
        this.searchRepositoryPort = searchRepositoryPort;
    }

    @Override
    public void deleteById(Long id) {
        searchRepositoryPort.deleteById(id);
    }

    @Override
    public void logicalDeleteById(Long id) {
        searchRepositoryPort.logicalDeleteById(id);
    }
}
