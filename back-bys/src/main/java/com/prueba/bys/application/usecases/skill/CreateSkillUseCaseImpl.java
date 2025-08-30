package com.prueba.bys.application.usecases.skill;

import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.in.skill.CreateSkillUseCase;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import com.prueba.bys.domain.services.SkillDomainService;
import org.springframework.stereotype.Service;

@Service
public class CreateSkillUseCaseImpl implements CreateSkillUseCase {
    private final SkillRepositoryPort skillRepositoryPort;
    private final SkillDomainService skillDomainService;

    public CreateSkillUseCaseImpl(SkillRepositoryPort skillRepositoryPort, SkillDomainService skillDomainService) {
        this.skillRepositoryPort = skillRepositoryPort;
        this.skillDomainService = skillDomainService;
    }

    @Override
    public Skill create(Skill skill) {
        skillDomainService.validateDuplicatedName(skill.getName());
        return skillRepositoryPort.save(skill);
    }
}
