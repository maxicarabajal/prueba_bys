package com.prueba.bys.infrastructure.mappers;

import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.infrastructure.dto.AvailabilityRequestDTO;
import com.prueba.bys.infrastructure.dto.AvailabilityResponseDTO;
import com.prueba.bys.infrastructure.entities.AvailabilityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AvailabilityMapper {

    public abstract Availability toModel(AvailabilityEntity entity);

    public abstract Availability toModel(AvailabilityRequestDTO dto);

    public abstract AvailabilityResponseDTO toDto(Availability model);

    public abstract AvailabilityEntity toEntity(Availability model);
}
