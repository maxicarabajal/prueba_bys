package com.prueba.bys.domain.models;

public class Skill {
    private Long id;
    private String name;
    private boolean isEnabled;

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
        this.isEnabled = true;
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

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
