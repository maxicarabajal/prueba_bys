package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.in.skill.CreateSkillUseCase;
import com.prueba.bys.infrastructure.dto.skill.SkillRequestDTO;
import com.prueba.bys.infrastructure.dto.skill.SkillResponseDTO;
import com.prueba.bys.infrastructure.mappers.SkillMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final CreateSkillUseCase createSkillUseCase;
    private final SkillMapper mapper;

    public SkillController(CreateSkillUseCase createSkillUseCase, SkillMapper mapper) {
        this.createSkillUseCase = createSkillUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<SkillResponseDTO> create(@RequestBody SkillRequestDTO dto) {
        Skill response = createSkillUseCase.create(mapper.toModel(dto));
        URI location = buildURI(response.getId());
        return ResponseEntity.created(location).body(mapper.toDTO(response));
    }

    private static URI buildURI(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
