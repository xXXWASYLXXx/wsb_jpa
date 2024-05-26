package com.capgemini.wsb.service;

import com.capgemini.wsb.dto.PatientTO;

public interface PatientService {
    PatientTO findById(final Long id);
    PatientTO create(final PatientTO patientTO);
    void deleteById(final Long id);
}
