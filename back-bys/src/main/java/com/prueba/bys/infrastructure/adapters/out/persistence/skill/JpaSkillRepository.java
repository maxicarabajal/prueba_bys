package com.prueba.bys.infrastructure.adapters.out.persistence.skill;

import com.prueba.bys.infrastructure.entities.SkillEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaSkillRepository extends JpaRepository<SkillEntity, Long> {

    Page<SkillEntity> findAllByEnabledTrue(Pageable pageable);

    @Modifying
    @Query("UPDATE SkillEntity s SET s.enabled = false WHERE s.id = :id")
    void logicalDeleteById(Long id);

    boolean existsByName(String name);
}
