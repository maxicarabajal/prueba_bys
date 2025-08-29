package com.prueba.bys.infrastructure.adapters.out.persistence.availability;

import com.prueba.bys.infrastructure.entities.AvailabilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAvailabilityRepository extends JpaRepository<AvailabilityEntity,Long> {

    boolean existsByName(String name);
}
