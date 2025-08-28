package com.prueba.bys.application.usecases;

import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.GetAvailabilityUseCase;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailabilityUseCaseImpl implements GetAvailabilityUseCase {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;

    public GetAvailabilityUseCaseImpl(AvailabilityRepositoryPort availabilityRepositoryPort) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
    }

    @Override
    public List<Availability> getAll() {
        return availabilityRepositoryPort.findAll();
    }

    @Override
    public Availability getById(Long id) {
        return availabilityRepositoryPort.findById(id);
    }
}
