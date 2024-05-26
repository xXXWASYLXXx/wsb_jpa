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
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientDaoImplIntegrationTest {

    @Autowired
    private PatientDaoImpl patientDaoImpl;

    @Test
    public void testShouldFindPatientByLastName() {
        // given
        AddressEntity janKowalskiAddressEntity = new AddressEntity();
        janKowalskiAddressEntity.setAddressLine1("Ul. Morska");
        janKowalskiAddressEntity.setAddressLine2("22");
        janKowalskiAddressEntity.setCity("Warszawa");
        janKowalskiAddressEntity.setPostalCode("71-002");

        PatientEntity janKowalskiPatientEntity = new PatientEntity();
        janKowalskiPatientEntity.setDateOfBirth(LocalDate.of(1990, Month.JANUARY, 1));
        janKowalskiPatientEntity.setEmail("jkowalski@email.com");
        janKowalskiPatientEntity.setFirstName("Jan");
        janKowalskiPatientEntity.setLastName("Kowalski");
        janKowalskiPatientEntity.setPatientNumber("123");
        janKowalskiPatientEntity.setTelephoneNumber("123456789");
        janKowalskiPatientEntity.setVip(true);
        janKowalskiPatientEntity.setAddress(janKowalskiAddressEntity);

        // when
        patientDaoImpl.save(janKowalskiPatientEntity);
        PatientEntity patientEntity = patientDaoImpl.findByLastName("Kowalski");

        // then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(patientEntity),
                () -> Assertions.assertEquals("Jan", patientEntity.getFirstName()),
                () -> Assertions.assertEquals("Kowalski", patientEntity.getLastName())
        );
    }

    @Test
    public void testShouldFindVipPatients() {
        // given
        AddressEntity janKowalskiAddressEntity = new AddressEntity();
        janKowalskiAddressEntity.setAddressLine1("Ul. Morska");
        janKowalskiAddressEntity.setAddressLine2("22");
        janKowalskiAddressEntity.setCity("Warszawa");
        janKowalskiAddressEntity.setPostalCode("71-002");

        PatientEntity janKowalskiPatientEntity = new PatientEntity();
        janKowalskiPatientEntity.setDateOfBirth(LocalDate.of(1990, Month.JANUARY, 1));
        janKowalskiPatientEntity.setEmail("jkowalski@email.com");
        janKowalskiPatientEntity.setFirstName("Jan");
        janKowalskiPatientEntity.setLastName("Kowalski");
        janKowalskiPatientEntity.setPatientNumber("123");
        janKowalskiPatientEntity.setTelephoneNumber("123456789");
        janKowalskiPatientEntity.setVip(true);
        janKowalskiPatientEntity.setAddress(janKowalskiAddressEntity);

        AddressEntity kamilKajakAddressEntity = new AddressEntity();
        kamilKajakAddressEntity.setAddressLine1("Ul. Dzika");
        kamilKajakAddressEntity.setAddressLine2("333");
        kamilKajakAddressEntity.setCity("Warszawa");
        kamilKajakAddressEntity.setPostalCode("01-003");

        PatientEntity kamilKajakPatientEntity = new PatientEntity();
        kamilKajakPatientEntity.setDateOfBirth(LocalDate.of(1991, Month.FEBRUARY, 2));
        kamilKajakPatientEntity.setEmail("kkajak@mail.com");
        kamilKajakPatientEntity.setFirstName("Kamil");
        kamilKajakPatientEntity.setLastName("Kajak");
        kamilKajakPatientEntity.setPatientNumber("124");
        kamilKajakPatientEntity.setTelephoneNumber("987654321");
        kamilKajakPatientEntity.setVip(false);
        kamilKajakPatientEntity.setAddress(kamilKajakAddressEntity);

        // when
        patientDaoImpl.save(janKowalskiPatientEntity);
        patientDaoImpl.save(kamilKajakPatientEntity);
        List<PatientEntity> foundVipPatients = patientDaoImpl.findVipPatients();

        // then
        final int vipPatientsCount = 2;  // NOTE: data.sql inserts 1 VIP patient, that's why we expect 2 here
        Assertions.assertAll(
                () -> Assertions.assertEquals(vipPatientsCount, foundVipPatients.size(), "Wrong number of VIP patients")
        );
    }
}