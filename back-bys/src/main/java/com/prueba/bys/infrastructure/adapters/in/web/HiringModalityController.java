package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.in.hiring_modality.CreateHiringModalityUseCase;
import com.prueba.bys.domain.ports.in.hiring_modality.DeleteHiringModalityUseCase;
import com.prueba.bys.domain.ports.in.hiring_modality.GetHiringModalityUseCase;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityRequestDTO;
import com.prueba.bys.infrastructure.dto.hiring_modality.HiringModalityResponseDTO;
import com.prueba.bys.infrastructure.mappers.HiringModalityMapper;
import com.prueba.bys.infrastructure.utils.PageMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/hiring-modality")
public class HiringModalityController {
    private final CreateHiringModalityUseCase createHiringModalityUseCase;
    private final GetHiringModalityUseCase getHiringModalityUseCase;
    private final DeleteHiringModalityUseCase deleteHiringModalityUseCase;
    private final HiringModalityMapper mapper;

    public HiringModalityController(CreateHiringModalityUseCase createHiringModalityUseCase, GetHiringModalityUseCase getHiringModalityUseCase, DeleteHiringModalityUseCase deleteHiringModalityUseCase, HiringModalityMapper mapper) {
        this.createHiringModalityUseCase = createHiringModalityUseCase;
        this.getHiringModalityUseCase = getHiringModalityUseCase;
        this.deleteHiringModalityUseCase = deleteHiringModalityUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<HiringModalityResponseDTO> create(@RequestBody HiringModalityRequestDTO dto) {
        HiringModality response = createHiringModalityUseCase.create(mapper.toModel(dto));
        URI location = buildURI(response.getId());
        return ResponseEntity.created(location).body(mapper.toDto(response));
    }

    @GetMapping
    public ResponseEntity<PageResult<HiringModalityResponseDTO>> findAllEnabled(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sort){
        PageResult<HiringModality> result = getHiringModalityUseCase.getAllEnabled(page, size,sort);
        return ResponseEntity.ok(PageMapper.toDto(result,mapper::toDto));
    }

    @GetMapping("/admin")
    public ResponseEntity<PageResult<HiringModalityResponseDTO>> findAll(@RequestParam(defaultValue = "0") int page,
                                                                         @RequestParam(defaultValue = "10") int size,
                                                                         @RequestParam(defaultValue = "id") String sort){
        PageResult<HiringModality> result = getHiringModalityUseCase.getAll(page, size,sort);
        return ResponseEntity.ok(PageMapper.toDto(result,mapper::toDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PageResult<HiringModalityResponseDTO>> delete(@PathVariable Long id){
        deleteHiringModalityUseCase.logicalDeleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/admin")
    public ResponseEntity<PageResult<HiringModalityResponseDTO>> logicalDelete(@PathVariable Long id){
        deleteHiringModalityUseCase.deleteById(id);
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
