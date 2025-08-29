package com.prueba.bys.domain.ports.in.hiring_modality;

import com.prueba.bys.domain.models.HiringModality;

public interface CreateHiringModalityUseCase {
    HiringModality create(HiringModality hiringModality);
}
