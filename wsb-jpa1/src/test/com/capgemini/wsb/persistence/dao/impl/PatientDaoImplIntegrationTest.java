package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoImplIntegrationTest {

    @Autowired
    private PatientDaoImpl patientDaoImpl;

    @Test
    public void testShouldFindPatientByLastName() {
        // given
        AddressEntity janKowalskiAddressTO = new AddressEntity();
        janKowalskiAddressTO.setAddressLine1("Ul. Morska");
        janKowalskiAddressTO.setAddressLine2("22");
        janKowalskiAddressTO.setCity("Warszawa");
        janKowalskiAddressTO.setPostalCode("71-002");

        PatientEntity janKowalskiPatientTO = new PatientEntity();
        janKowalskiPatientTO.setDateOfBirth(LocalDate.of(1990, Month.JANUARY, 1));
        janKowalskiPatientTO.setEmail("jkowalski@email.com");
        janKowalskiPatientTO.setFirstName("Jan");
        janKowalskiPatientTO.setLastName("Kowalski");
        janKowalskiPatientTO.setPatientNumber("123");
        janKowalskiPatientTO.setTelephoneNumber("123456789");
        janKowalskiPatientTO.setVip(true);
        janKowalskiPatientTO.setAddress(janKowalskiAddressTO);

        // when
        patientDaoImpl.save(janKowalskiPatientTO);
        PatientEntity patientEntity = patientDaoImpl.findByLastName("Kowalski");

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(patientEntity),
                () -> Assertions.assertEquals("Jan", patientEntity.getFirstName()),
                () -> Assertions.assertEquals("Kowalski", patientEntity.getLastName())
        );
    }
}