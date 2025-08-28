package com.prueba.bys.domain.ports.in;

import com.prueba.bys.domain.models.Availability;

public interface UpdateAvailabilityUseCase {

    Availability update(Availability availability);
}
