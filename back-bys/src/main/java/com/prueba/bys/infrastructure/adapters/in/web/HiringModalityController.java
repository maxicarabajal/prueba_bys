package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.in.hiring_modality.CreateHiringModalityUseCase;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityRequestDTO;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityResponseDTO;
import com.prueba.bys.infrastructure.mappers.HiringModalityMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/hiring-modality")
public class HiringModalityController {
    private final CreateHiringModalityUseCase createHiringModalityUseCase;
    private final HiringModalityMapper mapper;

    public HiringModalityController(CreateHiringModalityUseCase createHiringModalityUseCase, HiringModalityMapper mapper) {
        this.createHiringModalityUseCase = createHiringModalityUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<HiringModalityResponseDTO> create(@RequestBody HiringModalityRequestDTO dto) {
        HiringModality response = createHiringModalityUseCase.create(mapper.toModel(dto));
        URI location = buildURI(response);
        return ResponseEntity.created(location).body(mapper.toDto(response));
    }

    private static URI buildURI(HiringModality response) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
    }
}
