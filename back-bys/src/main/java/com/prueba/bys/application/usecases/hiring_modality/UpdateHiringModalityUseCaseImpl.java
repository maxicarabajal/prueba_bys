package com.prueba.bys.application.usecases.hiring_modality;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.in.hiring_modality.UpdateHiringModalityUseCase;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import com.prueba.bys.domain.services.HiringModalityDomainService;
import org.springframework.stereotype.Service;

@Service
public class UpdateHiringModalityUseCaseImpl implements UpdateHiringModalityUseCase {
    private final HiringModalityRepositoryPort hiringModalityRepositoryPort;
    private final HiringModalityDomainService hiringModalityDomainService;

    public UpdateHiringModalityUseCaseImpl(HiringModalityRepositoryPort hiringModalityRepositoryPort, HiringModalityDomainService hiringModalityDomainService) {
        this.hiringModalityRepositoryPort = hiringModalityRepositoryPort;
        this.hiringModalityDomainService = hiringModalityDomainService;
    }

    @Override
    public HiringModality update(HiringModality hiringModality) {
        HiringModality foundHiringModality = hiringModalityRepositoryPort.findById(hiringModality.getId());

        if (foundHiringModality == null) {
            throw new NotFoundException("Modalidad de contratación no encontrada.");
        }

        hiringModalityDomainService.validateDuplicatedName(hiringModality.getName());

        foundHiringModality.setName(hiringModality.getName());
        return hiringModalityRepositoryPort.save(foundHiringModality);
    }
}
