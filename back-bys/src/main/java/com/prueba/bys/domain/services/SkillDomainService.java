package com.prueba.bys.domain.services;

import com.prueba.bys.domain.ports.out.SkillRepositoryPort;

public class SkillDomainService {
    private final SkillRepositoryPort skillRepositoryPort;

    public SkillDomainService(SkillRepositoryPort skillRepositoryPort) {
        this.skillRepositoryPort = skillRepositoryPort;
    }

    public void validateDuplicatedName(String name) {
        skillRepositoryPort.existsByName(name);
    }
}
