package com.prueba.bys.infrastructure.mappers;

import com.prueba.bys.domain.models.Search;
import com.prueba.bys.infrastructure.dto.search.SearchRequestDTO;
import com.prueba.bys.infrastructure.dto.search.SearchResponseDTO;
import com.prueba.bys.infrastructure.entities.SearchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {AvailabilityMapper.class, HiringModalityMapper.class})
public abstract class SearchMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "name", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "finishedAt", ignore = true),
            @Mapping(target = "enabled", ignore = true),
            @Mapping(target = "availability",source = "availability",qualifiedByName = "mapIdToAvailability"),
            @Mapping(target = "hiringModality",source = "hiringModality",qualifiedByName = "mapIdToHiringModality")
    })
    public abstract Search toModel(SearchRequestDTO dto);

    /*@Mappings({
            @Mapping(target = "enabled", source = "enabled")
    })*/
    public abstract Search toModel(SearchEntity entity);

    /*@Mappings({
            @Mapping(target = "enabled", source = "enabled")
    })*/
    public abstract SearchEntity toEntity(Search model);

    public abstract SearchResponseDTO toDto(Search model);


}
