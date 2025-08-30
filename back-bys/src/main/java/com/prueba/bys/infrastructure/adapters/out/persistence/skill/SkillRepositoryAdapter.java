package com.prueba.bys.infrastructure.adapters.out.persistence.skill;

import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import com.prueba.bys.infrastructure.entities.SkillEntity;
import com.prueba.bys.infrastructure.mappers.SkillMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillRepositoryAdapter implements SkillRepositoryPort {
    private final JpaSkillRepository jpaSkillRepository;
    private final SkillMapper mapper;

    public SkillRepositoryAdapter(JpaSkillRepository jpaSkillRepository, SkillMapper mapper) {
        this.jpaSkillRepository = jpaSkillRepository;
        this.mapper = mapper;
    }

    @Override
    public Skill save(Skill skill) {
        SkillEntity entity = mapper.toEntity(skill);
        SkillEntity savedSkill = jpaSkillRepository.save(entity);
        return mapper.toModel(savedSkill);
    }

    @Override
    public List<Skill> findAll() {
        return jpaSkillRepository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public Skill findById(Long id) {
        return jpaSkillRepository.findById(id).map(mapper::toModel).get();
    }

    @Override
    public void deleteById(Long id) {
        jpaSkillRepository.deleteById(id);
    }

    @Override
    public void logicalDeleteById(Long id) {
        jpaSkillRepository.logicalDeleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaSkillRepository.existsByName(name);
    }
}
