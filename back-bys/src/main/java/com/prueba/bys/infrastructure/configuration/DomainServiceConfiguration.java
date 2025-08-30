package com.prueba.bys.infrastructure.configuration;

import com.prueba.bys.domain.ports.out.AvailabilityRepositoryPort;
import com.prueba.bys.domain.ports.out.HiringModalityRepositoryPort;
import com.prueba.bys.domain.ports.out.SearchRepositoryPort;
import com.prueba.bys.domain.services.AvailabilityDomainService;
import com.prueba.bys.domain.services.HiringModalityDomainService;
import com.prueba.bys.domain.services.SearchDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainServiceConfiguration {
    private final AvailabilityRepositoryPort availabilityRepositoryPort;
    private final HiringModalityRepositoryPort hiringModalityRepositoryPort;
    private final SearchRepositoryPort searchRepositoryPort;

    public DomainServiceConfiguration(AvailabilityRepositoryPort availabilityRepositoryPort,
                                      HiringModalityRepositoryPort hiringModalityRepositoryPort,
                                      SearchRepositoryPort searchRepositoryPort) {
        this.availabilityRepositoryPort = availabilityRepositoryPort;
        this.hiringModalityRepositoryPort = hiringModalityRepositoryPort;
        this.searchRepositoryPort = searchRepositoryPort;
    }

    @Bean
    public AvailabilityDomainService availabilityDomainService() {
        return new AvailabilityDomainService(availabilityRepositoryPort);
    }

    @Bean
    public HiringModalityDomainService hiringModalityDomainService() {
        return new HiringModalityDomainService(hiringModalityRepositoryPort);
    }

    @Bean
    public SearchDomainService domainService(){
        return new SearchDomainService(searchRepositoryPort);
    }


}
