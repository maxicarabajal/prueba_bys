package com.prueba.bys.infrastructure.adapters.out.persistence.availability;

import com.prueba.bys.infrastructure.entities.AvailabilityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAvailabilityRepository extends JpaRepository<AvailabilityEntity,Long> {

    boolean existsByName(String name);

    Page<AvailabilityEntity> findAllByEnabledTrue(Pageable pageable);

    @Modifying
    @Query("UPDATE AvailabilityEntity a SET a.enabled = false WHERE a.id = :id")
    void logicalDeleteById(Long id);
}
