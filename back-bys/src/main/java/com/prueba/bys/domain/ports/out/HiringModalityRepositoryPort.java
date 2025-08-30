package com.prueba.bys.domain.ports.out;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.HiringModality;

public interface HiringModalityRepositoryPort {

    HiringModality save(HiringModality hiringModality);

    PageResult<HiringModality> findAll(int page, int size, String sort);

    PageResult<HiringModality> findAllEnabled(int page, int size, String sort);

    HiringModality findById(Long id);

    void deleteById(Long id);

    void logicalDeleteById(Long id);

    boolean existsByName(String name);
}
