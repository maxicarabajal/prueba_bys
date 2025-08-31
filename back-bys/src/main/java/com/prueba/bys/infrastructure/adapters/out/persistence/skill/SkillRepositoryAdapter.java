package com.prueba.bys.infrastructure.adapters.out.persistence.skill;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import com.prueba.bys.infrastructure.entities.SkillEntity;
import com.prueba.bys.infrastructure.mappers.SkillMapper;
import com.prueba.bys.infrastructure.utils.CustomSort;
import com.prueba.bys.infrastructure.utils.PageMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public PageResult<Skill> findAll(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, CustomSort.from(sort));

        Page<SkillEntity> pagination = jpaSkillRepository.findAll(pageable);

        return PageMapper.fromPage(pagination,mapper::toModel);
    }

    @Override
    public PageResult<Skill> findAllEnabled(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, CustomSort.from(sort));

        Page<SkillEntity> pagination = jpaSkillRepository.findAllByEnabledTrue(pageable);

        return PageMapper.fromPage(pagination,mapper::toModel);
    }


    @Override
    public Skill findById(Long id) {
        Optional<SkillEntity> optional = jpaSkillRepository.findById(id);

        if (optional.isPresent()) {
            return optional.map(mapper::toModel).get();
        }

        return null;
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
