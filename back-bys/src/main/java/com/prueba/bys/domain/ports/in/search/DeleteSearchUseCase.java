package com.prueba.bys.domain.ports.in.search;

public interface DeleteSearchUseCase {
    void deleteById(Long id);
    void logicalDeleteById(Long id);
}
