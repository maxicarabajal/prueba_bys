package com.prueba.bys.application.usecases.availability;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.availability.GetAvailabilityUseCase;
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
    public PageResult<Availability> getAll(int page, int size, String sort) {
        return availabilityRepositoryPort.findAll(page, size, sort);
    }

    @Override
    public PageResult<Availability> getAllEnabled(int page, int size, String sort) {
        return availabilityRepositoryPort.findAllEnabled(page,size,sort);
    }

    @Override
    public Availability getById(Long id) {
        return availabilityRepositoryPort.findById(id);
    }
}
