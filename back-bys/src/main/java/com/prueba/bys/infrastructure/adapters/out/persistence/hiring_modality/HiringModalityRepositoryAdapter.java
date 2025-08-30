package com.prueba.bys.infrastructure.adapters.out.persistence.hiring_modality;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import com.prueba.bys.infrastructure.entities.HiringModalityEntity;
import com.prueba.bys.infrastructure.mappers.HiringModalityMapper;
import com.prueba.bys.infrastructure.utils.PageMapper;
import com.prueba.bys.infrastructure.utils.CustomSort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public PageResult<HiringModality> findAll(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, CustomSort.from(sort));

        Page<HiringModalityEntity> pagination = jpaHiringModalityRepository.findAll(pageable);

        return PageMapper.fromPage(pagination, mapper::toModel);
    }

    @Override
    public PageResult<HiringModality> findAllEnabled(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, CustomSort.from(sort));

        Page<HiringModalityEntity> pagination = jpaHiringModalityRepository.findAllByEnabledTrue(pageable);

        return PageMapper.fromPage(pagination, mapper::toModel);
    }

    @Override
    public HiringModality findById(Long id) {
        Optional<HiringModalityEntity> optional = jpaHiringModalityRepository.findById(id);
        if (optional.isPresent()) {
            return optional.map(mapper::toModel).get();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        jpaHiringModalityRepository.deleteById(id);
    }

    @Override
    public void logicalDeleteById(Long id) {
        jpaHiringModalityRepository.logicalDeleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return jpaHiringModalityRepository.existsByName(name);
    }
}
