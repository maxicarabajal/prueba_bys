package com.prueba.bys.infrastructure.mappers;

import com.prueba.bys.application.exceptions.NotFoundException;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.infrastructure.adapters.out.persistence.hiring_modality.JpaHiringModalityRepository;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityRequestDTO;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityResponseDTO;
import com.prueba.bys.infrastructure.entities.HiringModalityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class HiringModalityMapper {

    @Autowired
    private JpaHiringModalityRepository hiringModalityRepository;

    public abstract HiringModality toModel(HiringModalityEntity entity);

    public abstract HiringModality toModel(HiringModalityRequestDTO dto);

    public abstract HiringModalityResponseDTO toDto(HiringModality model);

    public abstract HiringModalityEntity toEntity(HiringModality model);

    @Named("mapIdToHiringModality")
    public HiringModality mapIdToHiringModality(Long id){
        return hiringModalityRepository.findById(id)
                .map(this::toModel)
                .orElseThrow( () -> new NotFoundException("Error no se encontro la modalidad de trabajo."));
    }
}
