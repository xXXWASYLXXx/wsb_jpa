package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.TreatmentType;

public class MedicalTreatmentTO {
    private Long id;
    private String description;
    private TreatmentType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TreatmentType getType() {
        return type;
    }

    public void setType(TreatmentType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MedicalTreatmentTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
