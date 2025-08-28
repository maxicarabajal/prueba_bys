package com.prueba.bys.domain.ports.in;

import com.prueba.bys.domain.models.Availability;

public interface CreateAvailabilityUseCase {

    Availability create(Availability availability);
}
