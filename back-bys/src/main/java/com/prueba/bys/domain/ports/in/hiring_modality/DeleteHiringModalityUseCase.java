package com.prueba.bys.domain.ports.in.hiring_modality;

public interface DeleteHiringModalityUseCase {

    void deleteById(Long id);

    void logicalDeleteById(Long id);
}
