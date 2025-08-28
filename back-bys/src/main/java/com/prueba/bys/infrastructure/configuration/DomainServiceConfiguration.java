package com.prueba.bys.infrastructure.configuration;

import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import com.prueba.bys.domain.services.AvailabilityDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServiceConfiguration {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;

    public DomainServiceConfiguration(AvailabilityRepositoryPort availabilityRepositoryPort) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
    }

    @Bean
    public AvailabilityDomainService availabilityDomainService() {
        return new AvailabilityDomainService(availabilityRepositoryPort);
    }


}
