package com.prueba.bys.domain.ports.in.hiring_modality;

import com.prueba.bys.domain.models.HiringModality;

import java.util.List;

public interface GetHiringModalityUseCase {
    List<HiringModality> getAll();

    HiringModality getById(Long id);
}
