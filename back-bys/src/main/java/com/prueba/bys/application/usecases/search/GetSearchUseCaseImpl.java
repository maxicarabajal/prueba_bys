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
        Search search = searchRepositoryPort.findById(id);
        if(search == null) throw new NotFoundException("no se encontro la busqueda con id: "+id);
        return search;
    }

    @Override
    public List<Search> getAll() {
        return searchRepositoryPort.findAll();
    }
}
