package com.prueba.bys.domain.ports.out;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Availability;

public interface AvailabilityRepositoryPort {

    Availability save(Availability availability);

    PageResult<Availability> findAll(int page, int size, String sort);

    PageResult<Availability> findAllEnabled(int page, int size, String sort);

    Availability findById(Long id);

    void deleteById(Long id);

    void logicalDeleteById(Long id);

    boolean existByName(String name);
}
