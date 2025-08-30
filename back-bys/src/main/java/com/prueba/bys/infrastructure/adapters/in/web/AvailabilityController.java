package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.availability.CreateAvailabilityUseCase;
import com.prueba.bys.infrastructure.dto.availability.AvailabilityRequestDTO;
import com.prueba.bys.infrastructure.dto.availability.AvailabilityResponseDTO;
import com.prueba.bys.infrastructure.mappers.AvailabilityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    private final CreateAvailabilityUseCase createAvailabilityUseCase;
    private final AvailabilityMapper mapper;

    public AvailabilityController(CreateAvailabilityUseCase createAvailabilityUseCase, AvailabilityMapper mapper) {
        this.createAvailabilityUseCase = createAvailabilityUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AvailabilityResponseDTO> create(AvailabilityRequestDTO dto) {
        Availability response = createAvailabilityUseCase.create(mapper.toModel(dto));
        URI location = buildURI(response.getId());
        return ResponseEntity.created(location).body(mapper.toDto(response));
    }

    private static URI buildURI(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
