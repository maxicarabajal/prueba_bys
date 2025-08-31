package com.prueba.bys.domain.models;

public class Availability {
    private Long id;
    private String name;
    private boolean enabled;

    public Availability(Long id, String name) {
        this.id = id;
        this.name = name;
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
