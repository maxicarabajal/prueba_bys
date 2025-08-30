package com.prueba.bys.domain.ports.in.hiring_modality;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.HiringModality;


public interface GetHiringModalityUseCase {
    PageResult<HiringModality> getAll(int page, int size,String sort);

    PageResult<HiringModality> getAllEnabled(int page, int size,String sort);

    HiringModality getById(Long id);
}
