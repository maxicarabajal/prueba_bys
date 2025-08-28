package com.prueba.bys.domain.ports.in;

import com.prueba.bys.domain.models.Availability;

import java.util.List;

public interface GetAvailabilityUseCase {

    List<Availability> getAll();

    Availability getById(Long id);
}
