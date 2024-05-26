package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;

@SpringBootTest
class PatientServiceImplIntegrationTest {
    @Autowired
    private PatientServiceImpl patientService;

    @Test
    @Transactional
    void shouldFindPatientById() {
        // given
        AddressTO janKowalskiAddressTO = new AddressTO();
        janKowalskiAddressTO.setAddressLine1("Ul. Morska");
        janKowalskiAddressTO.setAddressLine2("22");
        janKowalskiAddressTO.setCity("Warszawa");
        janKowalskiAddressTO.setPostalCode("71-002");

        PatientTO janKowalskiPatientTO = new PatientTO();
        janKowalskiPatientTO.setDateOfBirth(LocalDate.of(1990, Month.JANUARY, 1));
        janKowalskiPatientTO.setEmail("jkowalski@email.com");
        janKowalskiPatientTO.setFirstName("Jan");
        janKowalskiPatientTO.setLastName("Kowalski");
        janKowalskiPatientTO.setPatientNumber("123456");
        janKowalskiPatientTO.setTelephoneNumber("123456789");
        janKowalskiPatientTO.setVip(true);
        janKowalskiPatientTO.setAddress(janKowalskiAddressTO);

        // when
        PatientTO createdJanKowalskiPatientTO = patientService.create(janKowalskiPatientTO);

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(createdJanKowalskiPatientTO, "PatientTO is null"),
                () -> Assertions.assertNotNull(createdJanKowalskiPatientTO.getId(), "PatientTO ID is null")
        );
    }
}