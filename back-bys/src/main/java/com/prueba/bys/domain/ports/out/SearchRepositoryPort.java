package com.prueba.bys.domain.ports.out;

import com.prueba.bys.domain.models.Search;
import java.util.List;

public interface SearchRepositoryPort {
    Search save(Search search);
    List<Search> findAll();
    Search findById(Long id);
    void deleteById(Long id);
    void logicalDeleteById(Long id);
    boolean existsName(String name);
}
