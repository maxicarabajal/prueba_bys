package com.prueba.bys.application.usecases.hiring_modality;

import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.in.hiring_modality.CreateHiringModalityUseCase;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import com.prueba.bys.domain.services.HiringModalityDomainService;
import org.springframework.stereotype.Service;

@Service
public class CreateHiringModalityUseCaseImpl implements CreateHiringModalityUseCase {
    private final HiringModalityRepositoryPort hiringModalityRepositoryPort;
    private final HiringModalityDomainService hiringModalityDomainService;

    public CreateHiringModalityUseCaseImpl(HiringModalityRepositoryPort hiringModalityRepositoryPort, HiringModalityDomainService hiringModalityDomainService) {
        this.hiringModalityRepositoryPort = hiringModalityRepositoryPort;
        this.hiringModalityDomainService = hiringModalityDomainService;
    }

    @Override
    public HiringModality create(HiringModality hiringModality) {
        hiringModalityDomainService.validateDuplicatedName(hiringModality.getName());

        return hiringModalityRepositoryPort.save(hiringModality);
    }

}
