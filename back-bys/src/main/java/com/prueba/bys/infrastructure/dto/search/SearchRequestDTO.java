package com.prueba.bys.infrastructure.dto.search;

import jakarta.validation.constraints.NotNull;

public class SearchRequestDTO{

    @NotNull private byte vacancies;
    private String linkJob;
    private String linkJobUpdatable;
    private Double remuneration;
    private String observations;
    @NotNull private Long availability;
    @NotNull private Long hiringModality;

    public byte getVacancies() {
        return vacancies;
    }

    public void setVacancies(byte vacancies) {
        this.vacancies = vacancies;
    }

    public String getLinkJob() {
        return linkJob;
    }

    public void setLinkJob(String linkJob) {
        this.linkJob = linkJob;
    }

    public String getLinkJobUpdatable() {
        return linkJobUpdatable;
    }

    public void setLinkJobUpdatable(String linkJobUpdatable) {
        this.linkJobUpdatable = linkJobUpdatable;
    }

    public Double getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(Double remuneration) {
        this.remuneration = remuneration;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public @NotNull Long getAvailability() {
        return availability;
    }

    public void setAvailability(@NotNull Long availability) {
        this.availability = availability;
    }

    public @NotNull Long getHiringModality() {
        return hiringModality;
    }

    public void setHiringModality(@NotNull Long hiringModality) {
        this.hiringModality = hiringModality;
    }
}
