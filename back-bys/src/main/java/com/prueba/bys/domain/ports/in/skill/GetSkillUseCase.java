package com.prueba.bys.domain.ports.in.skill;

import com.prueba.bys.domain.models.Skill;

import java.util.List;

public interface GetSkillUseCase {

    List<Skill> getAll();

    Skill getById(Long id);

}
