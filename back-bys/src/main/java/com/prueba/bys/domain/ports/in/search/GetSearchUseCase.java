package com.prueba.bys.domain.ports.in.search;

import com.prueba.bys.domain.models.Search;
import java.util.List;

public interface GetSearchUseCase {
    Search getById(Long id);
    List<Search> getAll();
}
