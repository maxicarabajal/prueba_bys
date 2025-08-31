package com.prueba.bys.application.usecases.skill;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.in.skill.UpdateSkillUseCase;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import com.prueba.bys.domain.services.SkillDomainService;
import org.springframework.stereotype.Service;

@Service
public class UpdateSkillUseCaseImpl implements UpdateSkillUseCase {
    private final SkillRepositoryPort skillRepositoryPort;
    private final SkillDomainService skillDomainService;

    public UpdateSkillUseCaseImpl(SkillRepositoryPort skillRepositoryPort, SkillDomainService skillDomainService) {
        this.skillRepositoryPort = skillRepositoryPort;
        this.skillDomainService = skillDomainService;
    }


    @Override
    public Skill update(Skill skill) {
        Skill foundSkill = skillRepositoryPort.findById(skill.getId());

        if (foundSkill == null) {
            throw new NotFoundException("Skill no encontrada.");
        }

        skillDomainService.validateDuplicatedName(skill.getName());

        return skillRepositoryPort.save(foundSkill);
    }
}
