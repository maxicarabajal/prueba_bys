package com.prueba.bys.application.usecases.availability;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.availability.UpdateAvailabilityUseCase;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import com.prueba.bys.domain.services.AvailabilityDomainService;
import org.springframework.stereotype.Service;

@Service
public class UpdateAvailabilityUseCaseImpl implements UpdateAvailabilityUseCase {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;
    private final AvailabilityDomainService availabilityDomainService;

    public UpdateAvailabilityUseCaseImpl(AvailabilityRepositoryPort availabilityRepositoryPort, AvailabilityDomainService availabilityDomainService) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
        this.availabilityDomainService = availabilityDomainService;
    }

    @Override
    public Availability update(Availability availability) {
        Availability foundAvailability = availabilityRepositoryPort.findById(availability.getId());

        if (foundAvailability == null) {
            throw new NotFoundException("Disponibilidad no encontrada.");
        }

        availabilityDomainService.validateDuplicatedName(availability.getName());

        foundAvailability.setName(availability.getName());

        return availabilityRepositoryPort.save(foundAvailability);
    }

}
