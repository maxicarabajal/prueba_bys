package com.prueba.bys.domain.ports.out;

import com.prueba.bys.domain.models.Availability;

import java.util.List;

public interface AvailabilityRepositoryPort {

    Availability save(Availability availability);

    List<Availability> findAll();

    Availability findById(Long id);

    boolean existByName(String name);
}
