package com.prueba.bys.infrastructure.adapters.out.persistence.search;

import com.prueba.bys.domain.models.Search;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;
import com.prueba.bys.infrastructure.entities.SearchEntity;
import com.prueba.bys.infrastructure.exceptions.EntityNotFoundException;
import com.prueba.bys.infrastructure.mappers.SearchMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchRepositoryAdapter implements SearchRepositoryPort {

    private final JpaSearchRepository jpaSearchRepository;
    private final SearchMapper searchMapper;

    public SearchRepositoryAdapter(JpaSearchRepository jpaSearchRepository,
                                   SearchMapper searchMapper){
        this.jpaSearchRepository = jpaSearchRepository;
        this.searchMapper = searchMapper;
    }

    @Override
    public Search save(Search search) {
        SearchEntity searchEntity = jpaSearchRepository.save(searchMapper.toEntity(search));
        return searchMapper.toModel(searchEntity);
    }

    @Override
    public List<Search> findAll() {
        return jpaSearchRepository.findAll()
                .stream()
                .map(searchMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Search findById(Long id){
        return jpaSearchRepository.findById(id).
                map(searchMapper::toModel)
                .orElseThrow( ()-> new EntityNotFoundException("Error, no se encontro la busqueda con id: "+id));
    }

    @Override
    public void deleteById(Long id) {
        jpaSearchRepository.deleteById(id);
    }

    @Override
    public void logicalDeleteById(Long id) {
        jpaSearchRepository.logicalDeleteById(id);
    }

    @Override
    public boolean existsName(String name) {
        return jpaSearchRepository.existsByName(name);
    }
}
