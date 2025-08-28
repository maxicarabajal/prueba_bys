package com.prueba.bys.application.usecases;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.UpdateAvailabilityUseCase;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class UpdateAvailabilityUseCaseImpl implements UpdateAvailabilityUseCase {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;

    public UpdateAvailabilityUseCaseImpl(AvailabilityRepositoryPort availabilityRepositoryPort) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
    }

    @Override
    public Availability update(Availability availability) {
        Availability foundAvailability = availabilityRepositoryPort.findById(availability.getId());
        if (foundAvailability == null) {
            throw new NotFoundException("Disponibilidad no encontrada.");
        }

        foundAvailability.setName(availability.getName());
        return availabilityRepositoryPort.save(foundAvailability);
    }

}
