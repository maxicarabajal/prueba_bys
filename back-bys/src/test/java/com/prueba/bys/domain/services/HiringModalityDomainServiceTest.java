package com.prueba.bys.domain.services;

import com.prueba.bys.domain.exceptions.DuplicatedNameException;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HiringModalityDomainServiceTest {
    public static final String ANY_NAME = "any name";

    @Mock
    private HiringModalityRepositoryPort hiringModalityRepositoryPort;

    @Test
    void shouldThrowDuplicatedNameException_whenNameAlreadyExists(){
        //GIVEN
        HiringModalityDomainService sut = new HiringModalityDomainService(hiringModalityRepositoryPort);
        when(hiringModalityRepositoryPort.existsByName(ANY_NAME)).thenReturn(true);

        //WHEN
        Executable executable = () -> sut.validateDuplicatedName(ANY_NAME);

        //THEN
        DuplicatedNameException e = assertThrows(DuplicatedNameException.class, executable);
        assertEquals("Modalidad de contratación ya registrada.", e.getMessage());

        verify(hiringModalityRepositoryPort).existsByName(ANY_NAME);
    }

    @Test
    void shouldValidateDuplicatedNameSuccessfully_whenNameIsUnique(){
        //GIVEN
        HiringModalityDomainService sut = new HiringModalityDomainService(hiringModalityRepositoryPort);
        when(hiringModalityRepositoryPort.existsByName(ANY_NAME)).thenReturn(false);

        //WHEN
        sut.validateDuplicatedName(ANY_NAME);

        //THEN
        verify(hiringModalityRepositoryPort).existsByName(ANY_NAME);
    }
}