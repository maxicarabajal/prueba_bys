package com.prueba.bys.domain.ports.in.skill;

public interface DeleteSkillUseCase {

    void deleteById(Long id);

    void logicalDeleteById(Long id);
}
