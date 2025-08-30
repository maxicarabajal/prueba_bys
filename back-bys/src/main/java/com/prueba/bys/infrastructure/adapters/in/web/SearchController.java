package com.prueba.bys.infrastructure.adapters.in.web;

import com.prueba.bys.application.usecases.search.CreateSearchUseCaseImpl;
import com.prueba.bys.application.usecases.search.DeleteSearchUseCaseImpl;
import com.prueba.bys.application.usecases.search.GetSearchUseCaseImpl;
import com.prueba.bys.application.usecases.search.UpdateSearchUseCaseImpl;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.models.Search;
import com.prueba.bys.domain.ports.in.search.CreateSearchUseCase;
import com.prueba.bys.domain.ports.in.search.DeleteSearchUseCase;
import com.prueba.bys.domain.ports.in.search.GetSearchUseCase;
import com.prueba.bys.domain.ports.in.search.UpdateSearchUseCase;
import com.prueba.bys.infrastructure.dto.search.SearchRequestDTO;
import com.prueba.bys.infrastructure.dto.search.SearchResponseDTO;
import com.prueba.bys.infrastructure.mappers.SearchMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchMapper searchMapper;
    private final CreateSearchUseCase createSearchUseCase;
    private final DeleteSearchUseCase deleteSearchUseCase;
    private final UpdateSearchUseCase updateSearchUseCase;
    private final GetSearchUseCase getSearchUseCase;

    public SearchController(SearchMapper searchMapper,
                            CreateSearchUseCase createSearchUseCase, DeleteSearchUseCase deleteSearchUseCase,
                            UpdateSearchUseCase updateSearchUseCase, GetSearchUseCase getSearchUseCase){
        this.searchMapper = searchMapper;
        this.createSearchUseCase = createSearchUseCase;
        this.deleteSearchUseCase = deleteSearchUseCase;
        this.updateSearchUseCase = updateSearchUseCase;
        this.getSearchUseCase = getSearchUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<SearchResponseDTO> createSearch(@RequestBody SearchRequestDTO searchRequestDTO){
        Search search = createSearchUseCase.create(searchMapper.toModel(searchRequestDTO));
        SearchResponseDTO searchResponseDTO = searchMapper.toDto(search);
        return ResponseEntity.created(buildURI(search.getId())).body(searchResponseDTO);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<SearchResponseDTO>> findAllSearch(){
        return ResponseEntity.ok(getSearchUseCase.getAll().stream().map(searchMapper::toDto).toList());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SearchResponseDTO> findSearchById(@PathVariable Long id){
        return ResponseEntity.ok(searchMapper.toDto(getSearchUseCase.getById(id)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        deleteSearchUseCase.deleteById(id);
        return ResponseEntity.ok("La busqueda se elimino de la base de datos.");
    }

    @DeleteMapping("/logical/delete/{id}")
    public ResponseEntity<String> logicalDeleteById(@PathVariable Long id){
        deleteSearchUseCase.logicalDeleteById(id);
        return ResponseEntity.ok("La busqueda se elimino logicamente de la base de datos.");
    }

    private static URI buildURI(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }

}


