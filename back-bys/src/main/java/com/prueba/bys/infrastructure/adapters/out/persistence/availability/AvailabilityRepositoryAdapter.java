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
import java.util.Optional;

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
        Optional<AvailabilityEntity> optional = jpaAvailabilityRepository.findById(id);

        if (optional.isPresent()) {
            return optional.map(mapper::toModel).get();
        }

        return null;
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
