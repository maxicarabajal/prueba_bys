package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.CreateAvailabilityUseCase;
import com.prueba.bys.infrastructure.dto.AvailabilityRequestDTO;
import com.prueba.bys.infrastructure.dto.AvailabilityResponseDTO;
import com.prueba.bys.infrastructure.mappers.AvailabilityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Availability availability = mapper.toModel(dto);
        Availability savedAvailability = createAvailabilityUseCase.create(availability);
        return ResponseEntity.ok(mapper.toDto(savedAvailability));
    }
}
