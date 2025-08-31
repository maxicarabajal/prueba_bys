package com.prueba.bys.domain.ports.in.search;

import com.prueba.bys.domain.models.Search;


public interface CreateSearchUseCase {
    Search create(Search search);
}
