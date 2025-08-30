package com.prueba.bys.domain.ports.out;

import com.prueba.bys.domain.models.Skill;

import java.util.List;

public interface SkillRepositoryPort {

    Skill save(Skill skill);

    List<Skill> findAll();

    Skill findById(Long id);

    void deleteById(Long id);

    void logicalDeleteById(Long id);

    boolean existsByName(String name);
}
