package com.prueba.bys.application.usecases.skill;

import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.in.skill.GetSkillUseCase;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSkillUseCaseImpl implements GetSkillUseCase {
    private final SkillRepositoryPort skillRepositoryPort;

    public GetSkillUseCaseImpl(SkillRepositoryPort skillRepositoryPort) {
        this.skillRepositoryPort = skillRepositoryPort;
    }

    @Override
    public List<Skill> getAll() {
        return skillRepositoryPort.findAll();
    }

    @Override
    public Skill getById(Long id) {
        return null;
    }
}
