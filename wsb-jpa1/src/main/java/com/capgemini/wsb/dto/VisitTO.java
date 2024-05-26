package com.capgemini.wsb.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class VisitTO {
    private Long id;
    private String description;
    private LocalDateTime time;
    private Set<MedicalTreatmentTO> medicalTreatments = new HashSet<>();
    private DoctorTO doctor;
    private PatientTO patient;

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Set<MedicalTreatmentTO> getMedicalTreatments() {
        return medicalTreatments;
    }

    public void setMedicalTreatments(Set<MedicalTreatmentTO> medicalTreatments) {
        this.medicalTreatments = medicalTreatments;
    }

    public DoctorTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorTO doctor) {
        this.doctor = doctor;
    }

    public PatientTO getPatient() {
        return patient;
    }

    public void setPatient(PatientTO patient) {
        this.patient = patient;
    }
}
