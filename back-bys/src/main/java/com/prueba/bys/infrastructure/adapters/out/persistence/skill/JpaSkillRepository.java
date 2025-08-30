package com.prueba.bys.infrastructure.adapters.out.persistence.skill;

import com.prueba.bys.infrastructure.entities.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaSkillRepository extends JpaRepository<SkillEntity, Long> {

    @Query("UPDATE SkillEntity s SET s.isEnabled = false WHERE s.id = :id")
    void logicalDeleteById(Long id);

    boolean existsByName(String name);
}
