package com.capgemini.wsb.dto;

import java.time.LocalDate;
import java.util.Set;

public class PatientTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String email;
    private String patientNumber;
    private LocalDate dateOfBirth;
    private Boolean isVip;
    private Set<VisitTO> visits;
    private AddressTO address;

}
