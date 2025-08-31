package com.prueba.bys.infrastructure.adapters.out.persistence.search;

import com.prueba.bys.infrastructure.entities.SearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface JpaSearchRepository extends JpaRepository<SearchEntity,Long> {

    boolean existsByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE SearchEntity s SET s.isEnabled = false WHERE s.id = :id")
    int logicalDeleteById(Long id);
}
