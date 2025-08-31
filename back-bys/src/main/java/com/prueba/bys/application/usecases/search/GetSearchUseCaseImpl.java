package com.prueba.bys.application.usecases.search;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Search;
import com.prueba.bys.domain.ports.in.search.GetSearchUseCase;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetSearchUseCaseImpl implements GetSearchUseCase {

    private final SearchRepositoryPort searchRepositoryPort;

    private GetSearchUseCaseImpl(SearchRepositoryPort searchRepositoryPort){
        this.searchRepositoryPort = searchRepositoryPort;
    }

    @Override
    public Search getById(Long id) {
        return searchRepositoryPort.findById(id);
    }

    @Override
    public List<Search> getAll() {
        return searchRepositoryPort.findAll();
    }
}
