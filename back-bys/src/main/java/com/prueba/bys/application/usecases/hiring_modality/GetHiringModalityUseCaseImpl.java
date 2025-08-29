package com.prueba.bys.application.usecases.hiring_modality;

import com.prueba.bys.domain.models.HiringModality;
import com.prueba.bys.domain.ports.in.hiring_modality.GetHiringModalityUseCase;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetHiringModalityUseCaseImpl implements GetHiringModalityUseCase {
    private final HiringModalityRepositoryPort hiringModalityRepositoryPort;

    public GetHiringModalityUseCaseImpl(HiringModalityRepositoryPort hiringModalityRepositoryPort) {
        this.hiringModalityRepositoryPort = hiringModalityRepositoryPort;
    }

    @Override
    public List<HiringModality> getAll() {
        return hiringModalityRepositoryPort.findAll();
    }

    @Override
    public HiringModality getById(Long id) {
        return hiringModalityRepositoryPort.findById(id);
    }
}
