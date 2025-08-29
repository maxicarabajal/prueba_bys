package com.prueba.bys.infrastructure.adapters.out.persistence.hiring_modality;

import com.prueba.bys.infrastructure.entities.HiringModalityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaHiringModalityRepository extends JpaRepository<HiringModalityEntity,Long> {
    boolean existsByName(String name);
}
