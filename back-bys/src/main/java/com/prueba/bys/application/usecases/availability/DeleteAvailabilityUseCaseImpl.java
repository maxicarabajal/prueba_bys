package com.prueba.bys.application.usecases.availability;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.availability.DeleteAvailabilityUseCase;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteAvailabilityUseCaseImpl implements DeleteAvailabilityUseCase {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;

    public DeleteAvailabilityUseCaseImpl(AvailabilityRepositoryPort availabilityRepositoryPort) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
    }

    @Override
    public void deleteById(Long id) {
        Availability foundAvailability = availabilityRepositoryPort.findById(id);

        validateNotFound(foundAvailability);

        availabilityRepositoryPort.deleteById(id);
    }

    @Override
    @Transactional
    public void logicalDeleteById(Long id) {
        Availability foundAvailability = availabilityRepositoryPort.findById(id);

        validateNotFound(foundAvailability);

        availabilityRepositoryPort.logicalDeleteById(id);
    }


    private static void validateNotFound(Availability foundAvailability) {
        if (foundAvailability == null) {
            throw new NotFoundException("Disponibilidad no encontrada.");
        }
    }
}
