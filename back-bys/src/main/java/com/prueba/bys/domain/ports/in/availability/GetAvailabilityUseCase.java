package com.prueba.bys.domain.ports.in.availability;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Availability;

import java.util.List;

public interface GetAvailabilityUseCase {

    PageResult<Availability> getAll(int page, int size, String sort);

    PageResult<Availability> getAllEnabled(int page, int size, String sort);

    Availability getById(Long id);
}
