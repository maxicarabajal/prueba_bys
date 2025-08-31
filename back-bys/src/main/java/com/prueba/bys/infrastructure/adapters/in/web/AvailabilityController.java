package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.in.availability.CreateAvailabilityUseCase;
import com.prueba.bys.domain.ports.in.availability.DeleteAvailabilityUseCase;
import com.prueba.bys.domain.ports.in.availability.GetAvailabilityUseCase;
import com.prueba.bys.infrastructure.dto.availability.AvailabilityRequestDTO;
import com.prueba.bys.infrastructure.dto.availability.AvailabilityResponseDTO;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityResponseDTO;
import com.prueba.bys.infrastructure.mappers.AvailabilityMapper;
import com.prueba.bys.infrastructure.utils.PageMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    private final CreateAvailabilityUseCase createAvailabilityUseCase;
    private final GetAvailabilityUseCase getAvailabilityUseCase;
    private final DeleteAvailabilityUseCase deleteAvailabilityUseCase;
    private final AvailabilityMapper mapper;

    public AvailabilityController(CreateAvailabilityUseCase createAvailabilityUseCase, GetAvailabilityUseCase getAvailabilityUseCase, DeleteAvailabilityUseCase deleteAvailabilityUseCase, AvailabilityMapper mapper) {
        this.createAvailabilityUseCase = createAvailabilityUseCase;
        this.getAvailabilityUseCase = getAvailabilityUseCase;
        this.deleteAvailabilityUseCase = deleteAvailabilityUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<AvailabilityResponseDTO> create(@RequestBody AvailabilityRequestDTO dto) {
        Availability response = createAvailabilityUseCase.create(mapper.toModel(dto));

        URI location = buildURI(response.getId());

        return ResponseEntity.created(location).body(mapper.toDto(response));
    }

    @GetMapping
    public ResponseEntity<PageResult<AvailabilityResponseDTO>> findAllEnabled(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        PageResult<Availability> pageResult = getAvailabilityUseCase.getAllEnabled(page, size, sort);

        return ResponseEntity.ok(PageMapper.toDto(pageResult, mapper::toDto));
    }

    @GetMapping("/admin")
    public ResponseEntity<PageResult<AvailabilityResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort) {

        PageResult<Availability> pageResult = getAvailabilityUseCase.getAll(page, size, sort);

        return ResponseEntity.ok(PageMapper.toDto(pageResult, mapper::toDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvailabilityResponseDTO> findOne(@PathVariable Long id) {
        Availability response = getAvailabilityUseCase.getById(id);

        return ResponseEntity.ok(mapper.toDto(response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResult<AvailabilityResponseDTO>> delete(@PathVariable Long id){
        deleteAvailabilityUseCase.logicalDeleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/admin")
    public ResponseEntity<PageResult<HiringModalityResponseDTO>> logicalDelete(@PathVariable Long id){
        deleteAvailabilityUseCase.deleteById(id);

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
