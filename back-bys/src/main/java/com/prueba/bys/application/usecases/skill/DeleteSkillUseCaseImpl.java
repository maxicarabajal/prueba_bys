package com.prueba.bys.application.usecases.skill;

import com.prueba.bys.domain.ports.in.skill.DeleteSkillUseCase;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteSkillUseCaseImpl implements DeleteSkillUseCase {
    private final SkillRepositoryPort skillRepositoryPort;

    public DeleteSkillUseCaseImpl(SkillRepositoryPort skillRepositoryPort) {
        this.skillRepositoryPort = skillRepositoryPort;
    }


    @Override
    public void deleteById(Long id) {
        skillRepositoryPort.deleteById(id);
    }

    @Override
    public void logicalDeleteById(Long id) {
        skillRepositoryPort.logicalDeleteById(id);
    }
}
