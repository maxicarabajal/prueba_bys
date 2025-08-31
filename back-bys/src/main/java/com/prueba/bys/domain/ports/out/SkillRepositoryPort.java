package com.prueba.bys.domain.ports.out;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Skill;

public interface SkillRepositoryPort {

    Skill save(Skill skill);

    PageResult<Skill> findAll(int page, int size, String sort);

    PageResult<Skill> findAllEnabled(int page, int size, String sort);

    Skill findById(Long id);

    void deleteById(Long id);

    void logicalDeleteById(Long id);

    boolean existsByName(String name);
}
