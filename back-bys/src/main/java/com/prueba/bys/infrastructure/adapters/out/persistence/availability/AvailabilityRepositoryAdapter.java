package com.prueba.bys.infrastructure.adapters.out.persistence.availability;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import com.prueba.bys.infrastructure.entities.AvailabilityEntity;
import com.prueba.bys.infrastructure.mappers.AvailabilityMapper;
import com.prueba.bys.infrastructure.utils.CustomSort;
import com.prueba.bys.infrastructure.utils.PageMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityRepositoryAdapter implements AvailabilityRepositoryPort {
    private final JpaAvailabilityRepository jpaAvailabilityRepository;
    private final AvailabilityMapper mapper;

    public AvailabilityRepositoryAdapter(JpaAvailabilityRepository jpaAvailabilityRepository, AvailabilityMapper mapper) {
        this.jpaAvailabilityRepository = jpaAvailabilityRepository;
        this.mapper = mapper;
    }

    @Override
    public Availability save(Availability availability) {
        AvailabilityEntity entity = mapper.toEntity(availability);

        AvailabilityEntity savedAvailability = jpaAvailabilityRepository.save(entity);
        System.out.println(savedAvailability);

        return mapper.toModel(savedAvailability);
    }

    @Override
    public PageResult<Availability> findAll(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, CustomSort.from(sort));

        Page<AvailabilityEntity> pagination = jpaAvailabilityRepository.findAll(pageable);

        return PageMapper.fromPage(pagination, mapper::toModel);
    }

    @Override
    public PageResult<Availability> findAllEnabled(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, CustomSort.from(sort));

        Page<AvailabilityEntity> pagination = jpaAvailabilityRepository.findAllByEnabledTrue(pageable);

        return PageMapper.fromPage(pagination, mapper::toModel);
    }


    @Override
    public Availability findById(Long id) {
        return jpaAvailabilityRepository.findById(id).map(mapper::toModel).get();
    }

    @Override
    public void deleteById(Long id) {
        jpaAvailabilityRepository.deleteById(id);
    }

    @Override
    public void logicalDeleteById(Long id) {
        jpaAvailabilityRepository.logicalDeleteById(id);
    }

    @Override
    public boolean existByName(String name) {
        return jpaAvailabilityRepository.existsByName(name);
    }
}
