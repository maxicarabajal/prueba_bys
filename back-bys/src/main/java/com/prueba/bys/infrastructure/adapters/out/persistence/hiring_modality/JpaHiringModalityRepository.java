package com.prueba.bys.infrastructure.adapters.out.persistence.hiring_modality;

import com.prueba.bys.infrastructure.entities.HiringModalityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JpaHiringModalityRepository extends JpaRepository<HiringModalityEntity,Long> {
    boolean existsByName(String name);

    Page<HiringModalityEntity> findAllByEnabledTrue(Pageable pageable);

    @Modifying
    @Query("UPDATE HiringModalityEntity h SET h.enabled = false WHERE h.id = :id")
    void logicalDeleteById(Long id);
}
