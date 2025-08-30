package com.prueba.bys.domain.ports.in.skill;

import com.prueba.bys.domain.models.Skill;

public interface CreateSkillUseCase {

    Skill create(Skill skill);
}
