package com.prueba.bys.application.usecases.skill;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.in.skill.GetSkillUseCase;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class GetSkillUseCaseImpl implements GetSkillUseCase {
    private final SkillRepositoryPort skillRepositoryPort;

    public GetSkillUseCaseImpl(SkillRepositoryPort skillRepositoryPort) {
        this.skillRepositoryPort = skillRepositoryPort;
    }

    @Override
    public PageResult<Skill> getAll(int page, int size, String sort) {
        return skillRepositoryPort.findAll(page,size,sort);
    }

    @Override
    public PageResult<Skill> getAllEnabled(int page, int size, String sort) {
        return skillRepositoryPort.findAllEnabled(page, size, sort);
    }

    @Override
    public Skill getById(Long id) {
        return skillRepositoryPort.findById(id);
    }
}
