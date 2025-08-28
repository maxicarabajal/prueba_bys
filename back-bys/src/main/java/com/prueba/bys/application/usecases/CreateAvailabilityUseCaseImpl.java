package com.prueba.bys.application.usecases;

import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.CreateAvailabilityUseCase;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import com.prueba.bys.domain.services.AvailabilityDomainService;
import org.springframework.stereotype.Service;

@Service
public class CreateAvailabilityUseCaseImpl implements CreateAvailabilityUseCase {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;
    private final AvailabilityDomainService availabilityDomainService;

    public CreateAvailabilityUseCaseImpl(AvailabilityRepositoryPort availabilityRepositoryPort, AvailabilityDomainService availabilityDomainService) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
        this.availabilityDomainService = availabilityDomainService;
    }


    @Override
    public Availability create(Availability availability) {
        availabilityDomainService.validateDuplicatedName(availability.getName());
        return availabilityRepositoryPort.save(availability);
    }


}
