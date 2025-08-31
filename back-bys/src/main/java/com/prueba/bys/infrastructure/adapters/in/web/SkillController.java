package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.models.Skill;
import com.prueba.bys.domain.ports.in.skill.CreateSkillUseCase;
import com.prueba.bys.domain.ports.in.skill.DeleteSkillUseCase;
import com.prueba.bys.domain.ports.in.skill.GetSkillUseCase;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityResponseDTO;
import com.prueba.bys.infrastructure.dto.skill.SkillRequestDTO;
import com.prueba.bys.infrastructure.dto.skill.SkillResponseDTO;
import com.prueba.bys.infrastructure.mappers.SkillMapper;
import com.prueba.bys.infrastructure.utils.PageMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final CreateSkillUseCase createSkillUseCase;
    private final GetSkillUseCase getSkillUseCase;
    private final DeleteSkillUseCase deleteSkillUseCase;
    private final SkillMapper mapper;

    public SkillController(CreateSkillUseCase createSkillUseCase, GetSkillUseCase getSkillUseCase, DeleteSkillUseCase deleteSkillUseCase, SkillMapper mapper) {
        this.createSkillUseCase = createSkillUseCase;
        this.getSkillUseCase = getSkillUseCase;
        this.deleteSkillUseCase = deleteSkillUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<SkillResponseDTO> create(@RequestBody SkillRequestDTO dto) {
        Skill response = createSkillUseCase.create(mapper.toModel(dto));

        URI location = buildURI(response.getId());

        return ResponseEntity.created(location).body(mapper.toDTO(response));
    }

    @GetMapping
    public ResponseEntity<PageResult<SkillResponseDTO>> findAllEnabled(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort){

        PageResult<Skill> result = getSkillUseCase.getAllEnabled(page, size,sort);

        return ResponseEntity.ok(PageMapper.toDto(result,mapper::toDTO));
    }

    @GetMapping("/admin")
    public ResponseEntity<PageResult<SkillResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort){

        PageResult<Skill> result = getSkillUseCase.getAll(page, size,sort);

        return ResponseEntity.ok(PageMapper.toDto(result,mapper::toDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillResponseDTO> findOne(@PathVariable Long id) {
        Skill response = getSkillUseCase.getById(id);

        return ResponseEntity.ok(mapper.toDTO(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResult<HiringModalityResponseDTO>> delete(@PathVariable Long id) {

        deleteSkillUseCase.logicalDeleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/admin")
    public ResponseEntity<PageResult<HiringModalityResponseDTO>> logicalDelete(@PathVariable Long id){
        deleteSkillUseCase.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    private static URI buildURI(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
