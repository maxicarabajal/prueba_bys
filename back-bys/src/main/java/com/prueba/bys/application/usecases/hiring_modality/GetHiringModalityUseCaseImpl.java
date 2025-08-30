package com.prueba.bys.application.usecases.hiring_modality;

import com.prueba.bys.domain.commons.PageResult;
import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.in.hiring_modality.GetHiringModalityUseCase;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class GetHiringModalityUseCaseImpl implements GetHiringModalityUseCase {
    private final HiringModalityRepositoryPort hiringModalityRepositoryPort;

    public GetHiringModalityUseCaseImpl(HiringModalityRepositoryPort hiringModalityRepositoryPort) {
        this.hiringModalityRepositoryPort = hiringModalityRepositoryPort;
    }

    @Override
    public PageResult<HiringModality> getAll(int page, int size, String sort) {
        return hiringModalityRepositoryPort.findAll(page,size,sort);
    }

    @Override
    public PageResult<HiringModality> getAllEnabled(int page, int size, String sort) {
        return hiringModalityRepositoryPort.findAllEnabled(page, size, sort);
    }

    @Override
    public HiringModality getById(Long id) {
        return hiringModalityRepositoryPort.findById(id);
    }
}
