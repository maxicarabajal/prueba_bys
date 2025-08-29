package com.prueba.bys.infrastructure.adapters.out.persistence.hiring_modality;

import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import com.prueba.bys.infrastructure.entities.HiringModalityEntity;
import com.prueba.bys.infrastructure.mappers.HiringModalityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringModalityRepositoryAdapter implements HiringModalityRepositoryPort {
    private final JpaHiringModalityRepository jpaHiringModalityRepository;
    private final HiringModalityMapper mapper;

    public HiringModalityRepositoryAdapter(JpaHiringModalityRepository jpaHiringModalityRepository, HiringModalityMapper mapper) {
        this.jpaHiringModalityRepository = jpaHiringModalityRepository;
        this.mapper = mapper;
    }

    @Override
    public HiringModality save(HiringModality hiringModality) {
        HiringModalityEntity entity = mapper.toEntity(hiringModality);
        HiringModalityEntity savedHiringModality = jpaHiringModalityRepository.save(entity);
        return mapper.toModel(savedHiringModality);
    }

    @Override
    public List<HiringModality> findAll() {
        return jpaHiringModalityRepository.findAll().stream().map(mapper::toModel).toList();
    }

    @Override
    public HiringModality findById(Long id) {
        return jpaHiringModalityRepository.findById(id).map(mapper::toModel).get();
    }

    @Override
    public boolean existsByName(String name) {
        return jpaHiringModalityRepository.existsByName(name);
    }
}
