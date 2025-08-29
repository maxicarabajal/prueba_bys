package com.prueba.bys.infrastructure.adapters.out.persistence;

import com.prueba.bys.domain.models.Availability;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import com.prueba.bys.infrastructure.entities.AvailabilityEntity;
import com.prueba.bys.infrastructure.mappers.AvailabilityMapper;
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
        return mapper.toModel(savedAvailability);
    }

    @Override
    public List<Availability> findAll() {
        return List.of();
    }

    @Override
    public Availability findById(Long id) {
        return null;
    }

    @Override
    public boolean existByName(String name) {
        return jpaAvailabilityRepository.existsByName(name);
    }
}
