package com.prueba.bys.domain.ports.out;

import com.prueba.bys.domain.models.HiringModality;

import java.util.List;

public interface HiringModalityRepositoryPort {

    HiringModality save(HiringModality hiringModality);

    List<HiringModality> findAll();

    HiringModality findById(Long id);

    boolean existsByName(String name);
}
