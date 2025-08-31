package com.prueba.bys.infrastructure.mappers;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.infrastructure.adapters.out.persistence.availability.JpaAvailabilityRepository;
import com.prueba.bys.infrastructure.dto.availability.AvailabilityRequestDTO;
import com.prueba.bys.infrastructure.dto.availability.AvailabilityResponseDTO;
import com.prueba.bys.infrastructure.entities.AvailabilityEntity;
import org.mapstruct.Mapper;

import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;


@Mapper(componentModel = "spring")
public abstract class AvailabilityMapper {

    @Autowired
    private JpaAvailabilityRepository jpaAvailabilityRepository;

    public abstract Availability toModel(AvailabilityEntity entity);

    public abstract Availability toModel(AvailabilityRequestDTO dto);

    public abstract AvailabilityResponseDTO toDto(Availability model);

    public abstract AvailabilityEntity toEntity(Availability model);

    @Named("mapIdToAvailability")
    public Availability mapIdToAvailability(Long id){
        return jpaAvailabilityRepository.findById(id)
                .map(this::toModel)
                .orElseThrow( () -> new NotFoundException("No Existe la disponibilidad."));
    }
}
