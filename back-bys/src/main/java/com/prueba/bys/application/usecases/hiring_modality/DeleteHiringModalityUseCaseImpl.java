package com.prueba.bys.application.usecases.hiring_modality;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.in.hiring_modality.DeleteHiringModalityUseCase;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteHiringModalityUseCaseImpl implements DeleteHiringModalityUseCase {
    private final HiringModalityRepositoryPort hiringModalityRepositoryPort;

    public DeleteHiringModalityUseCaseImpl(HiringModalityRepositoryPort hiringModalityRepositoryPort) {
        this.hiringModalityRepositoryPort = hiringModalityRepositoryPort;
    }

    @Override
    public void deleteById(Long id) {
        HiringModality foundHiaringModality = hiringModalityRepositoryPort.findById(id);

        if (foundHiaringModality == null) {
            throw new NotFoundException("Modalidad de contratación no encontrada.");
        }

        hiringModalityRepositoryPort.deleteById(id);
    }

    @Override
    @Transactional
    public void logicalDeleteById(Long id) {
        HiringModality foundHiaringModality = hiringModalityRepositoryPort.findById(id);

        if (foundHiaringModality == null) {
            throw new NotFoundException("Modalidad de contratación no encontrada.");
        }

        hiringModalityRepositoryPort.logicalDeleteById(id);

    }
}
