package com.prueba.bys.domain.services;

import com.prueba.bys.domain.exceptions.DuplicatedNameException;
import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AvailabilityDomainServiceTest {
    public static final String ANY_NAME = "any name";

    @Mock
    private AvailabilityRepositoryPort availabilityRepositoryPort;

    @Test
    void shouldThrowDuplicatedNameException_whenNameAlreadyExists(){
        //GIVEN
        AvailabilityDomainService sut = new AvailabilityDomainService(availabilityRepositoryPort);
        when(availabilityRepositoryPort.existByName(ANY_NAME)).thenReturn(true);

        //WHEN
        Executable executable = () -> sut.validateDuplicatedName(ANY_NAME);

        //THEN
        DuplicatedNameException e = assertThrows(DuplicatedNameException.class, executable);
        assertEquals("Disponibilidad ya registrada.", e.getMessage());

        verify(availabilityRepositoryPort).existByName(ANY_NAME);
    }
    
    @Test
    void shouldValidateDuplicatedNameSuccessfully_whenNameIsUnique(){
        //GIVEN
        String name = "any name";
        AvailabilityDomainService sut = new AvailabilityDomainService(availabilityRepositoryPort);
        when(availabilityRepositoryPort.existByName(name)).thenReturn(false);
        
        //WHEN
        sut.validateDuplicatedName(name);
        
        //THEN
        verify(availabilityRepositoryPort).existByName(name);
    }

}