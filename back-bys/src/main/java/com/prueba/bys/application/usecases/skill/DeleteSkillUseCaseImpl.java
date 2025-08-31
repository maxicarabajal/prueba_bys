package com.prueba.bys.application.usecases.skill;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.in.skill.DeleteSkillUseCase;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteSkillUseCaseImpl implements DeleteSkillUseCase {
    private final SkillRepositoryPort skillRepositoryPort;

    public DeleteSkillUseCaseImpl(SkillRepositoryPort skillRepositoryPort) {
        this.skillRepositoryPort = skillRepositoryPort;
    }


    @Override
    public void deleteById(Long id) {
        Skill foundSkill = skillRepositoryPort.findById(id);

        validateNotFound(foundSkill);

        skillRepositoryPort.deleteById(id);
    }

    @Override
    @Transactional
    public void logicalDeleteById(Long id) {
        Skill foundSkill = skillRepositoryPort.findById(id);

        validateNotFound(foundSkill);

        skillRepositoryPort.logicalDeleteById(id);
    }


    private static void validateNotFound(Skill foundSkill) {
        if (foundSkill == null) {
            throw new NotFoundException("Skill no encontrada.");
        }
    }
}
