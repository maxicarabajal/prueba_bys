package com.prueba.bys.infrastructure.mappers;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityRequestDTO;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityResponseDTO;
import com.prueba.bys.infrastructure.entities.HiringModalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class HiringModalityMapper {

    public abstract HiringModality toModel(HiringModalityEntity entity);

    @Mapping(target = "enabled", ignore = true)
    public abstract HiringModality toModel(HiringModalityRequestDTO dto);

    public abstract HiringModalityResponseDTO toDto(HiringModality model);

    public abstract HiringModalityEntity toEntity(HiringModality model);

}
