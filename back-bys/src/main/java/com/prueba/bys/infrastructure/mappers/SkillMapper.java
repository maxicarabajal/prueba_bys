package com.prueba.bys.infrastructure.mappers;

import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.infrastructure.dto.skill.SkillRequestDTO;
import com.prueba.bys.infrastructure.dto.skill.SkillResponseDTO;
import com.prueba.bys.infrastructure.entities.SkillEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SkillMapper {

    public abstract Skill toModel(SkillEntity entity);

    public abstract Skill toModel(SkillRequestDTO dto);

    public abstract SkillEntity toEntity(Skill model);

    public abstract SkillResponseDTO toDTO(Skill skill);
}
