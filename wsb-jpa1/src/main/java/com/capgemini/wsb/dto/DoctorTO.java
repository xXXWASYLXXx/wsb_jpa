package com.capgemini.wsb.dto;

import com.capgemini.wsb.persistence.enums.Specialization;

import java.util.HashSet;
import java.util.Set;

public class DoctorTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String doctorNumber;
    private Specialization specialization;
    private Set<VisitTO> visits = new HashSet<>();
    private AddressTO address;

    public void addVisit(VisitTO visit) {
        visit.setDoctor(this);
        visits.add(visit);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Set<VisitTO> getVisits() {
        return visits;
    }

    public void setVisits(Set<VisitTO> visits) {
        this.visits = visits;
    }

    public AddressTO getAddress() {
        return address;
    }

    public void setAddress(AddressTO address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DoctorTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", doctorNumber='" + doctorNumber + '\'' +
                ", specialization=" + specialization +
//                ", visits=" + visits +
                ", address=" + address +
                '}';
    }
}
