package com.prueba.bys.domain.services;

import com.prueba.bys.domain.exceptions.DuplicatedNameException;
import com.prueba.bys.domain.ports.out.SkillRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SkillDomainServiceTest {
    public static final String ANY_NAME = "any name";

    @Mock
    private SkillRepositoryPort skillRepositoryPort;

    @Test
    void shouldThrowDuplicatedNameException_whenNameAlreadyExists(){
        //GIVEN
        SkillDomainService sut = new SkillDomainService(skillRepositoryPort);
        when(skillRepositoryPort.existsByName(ANY_NAME)).thenReturn(true);

        //WHEN
        Executable executable = () -> sut.validateDuplicatedName(ANY_NAME);

        //THEN
        DuplicatedNameException e = assertThrows(DuplicatedNameException.class, executable);
        assertEquals("Skill ya registrado.", e.getMessage());

        verify(skillRepositoryPort).existsByName(ANY_NAME);
    }

    @Test
    void shouldValidateDuplicatedNameSuccessfully_whenNameIsUnique(){
        //GIVEN
        String name = "any name";
        SkillDomainService sut = new SkillDomainService(skillRepositoryPort);
        when(skillRepositoryPort.existsByName(name)).thenReturn(false);

        //WHEN
        sut.validateDuplicatedName(name);

        //THEN
        verify(skillRepositoryPort).existsByName(name);
    }
}