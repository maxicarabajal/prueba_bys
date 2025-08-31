package com.prueba.bys.domain.ports.in.skill;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Skill;

public interface GetSkillUseCase {

    PageResult<Skill> getAll(int page, int size, String sort);

    PageResult<Skill> getAllEnabled(int page, int size, String sort);

    Skill getById(Long id);

}
