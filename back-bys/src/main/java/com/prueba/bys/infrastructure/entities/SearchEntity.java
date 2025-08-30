package com.prueba.bys.infrastructure.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search")
public class SearchEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "finished_At")
    private LocalDateTime finishedAt;
    @Column(name = "vacancies")
    private byte vacancies;
    @Column(name = "link_job")
    private String linkJob;
    @Column(name = "link_job_updatable")
    private String linkJobUpdatable;
    @Column(name = "remuneration")
    private Double remuneration;
    @Column(name = "observations")
    private String observations;

    @ManyToOne
    @JoinColumn(name = "availability")
    private AvailabilityEntity availability;

    @ManyToOne
    @JoinColumn(name = "hiring_modality")
    private HiringModalityEntity hiringModality;

    @Column(name = "enabled")
    private boolean isEnabled;


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

    public AvailabilityEntity getAvailability() {
        return availability;
    }

    public void setAvailability(AvailabilityEntity availability) {
        this.availability = availability;
    }

    public HiringModalityEntity getHiringModality() {
        return hiringModality;
    }

    public void setHiringModality(HiringModalityEntity hiringModality) {
        this.hiringModality = hiringModality;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
