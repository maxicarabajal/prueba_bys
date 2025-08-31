package com.prueba.bys.domain.models;

import java.time.LocalDateTime;

public class Search {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime finishedAt;
    private byte vacancies;
    private String linkJob;
    private String linkJobUpdatable;
    private Double remuneration;
    private String observations;
    private Availability availability;
    private HiringModality hiringModality;
    private boolean isEnabled;

    public Search(Long id, byte vacancies, String linkJob, String linkJobUpdatable,
                  Double remuneration, String observations, Availability availability,
                  HiringModality hiringModality) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.vacancies = vacancies;
        this.linkJob = linkJob;
        this.linkJobUpdatable = linkJobUpdatable;
        this.remuneration = remuneration;
        this.observations = observations;
        this.availability = availability;
        this.hiringModality = hiringModality;
        this.isEnabled = true;
    }

    public String generateName(){
        StringBuilder name = new StringBuilder();
        name.append(this.id).append(" ")
                .append("nombreCliente").append(" ")
                .append("java").append(" ")
                .append(this.vacancies);

        return name.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

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

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public HiringModality getHiringModality() {
        return hiringModality;
    }

    public void setHiringModality(HiringModality hiringModality) {
        this.hiringModality = hiringModality;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
