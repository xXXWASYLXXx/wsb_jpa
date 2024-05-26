package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.enums.Specialization;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

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
        janKowalskiPatientTO.setPatientNumber("123");
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

    @Test
    @Transactional
    void shouldSaveAndRemovePatientWithoutRemovingDoctor() {
        // given
        AddressTO kamilKajakAddressTO = new AddressTO();
        kamilKajakAddressTO.setAddressLine1("Ul. Dzika");
        kamilKajakAddressTO.setAddressLine2("333");
        kamilKajakAddressTO.setCity("Warszawa");
        kamilKajakAddressTO.setPostalCode("01-003");

        PatientTO kamilKajakPatientTO = new PatientTO();
        kamilKajakPatientTO.setDateOfBirth(LocalDate.of(1991, Month.FEBRUARY, 2));
        kamilKajakPatientTO.setEmail("kkajak@mail.com");
        kamilKajakPatientTO.setFirstName("Kamil");
        kamilKajakPatientTO.setLastName("Kajak");
        kamilKajakPatientTO.setPatientNumber("124");
        kamilKajakPatientTO.setTelephoneNumber("987654321");
        kamilKajakPatientTO.setVip(false);
        kamilKajakPatientTO.setAddress(kamilKajakAddressTO);

        AddressTO janKowalskiAddressTO = new AddressTO();
        janKowalskiAddressTO.setAddressLine1("Ul. Krucza");
        janKowalskiAddressTO.setAddressLine2("11");
        janKowalskiAddressTO.setCity("Poznań");
        janKowalskiAddressTO.setPostalCode("62-030");

        DoctorTO janKowalskiDoctorTO = new DoctorTO();
        janKowalskiDoctorTO.setDoctorNumber("123");
        janKowalskiDoctorTO.setEmail("jkowalski@email.com");
        janKowalskiDoctorTO.setFirstName("Jan");
        janKowalskiDoctorTO.setLastName("Kowalski");
        janKowalskiDoctorTO.setSpecialization(Specialization.SURGEON);
        janKowalskiDoctorTO.setTelephoneNumber("123456789");
        janKowalskiDoctorTO.setAddress(janKowalskiAddressTO);

        VisitTO kamilKajakVisitTO = new VisitTO();
        kamilKajakVisitTO.setDescription("First visit");
        kamilKajakVisitTO.setTime(LocalDateTime.of(2020, Month.JANUARY, 1, 10, 0));
        kamilKajakVisitTO.setDoctor(janKowalskiDoctorTO);
        kamilKajakVisitTO.setPatient(kamilKajakPatientTO);

        Set<VisitTO> kamilKajakVisits = new HashSet<>();
        kamilKajakVisits.add(kamilKajakVisitTO);
        kamilKajakPatientTO.setVisits(kamilKajakVisits);

        // when
        PatientTO createdKamilKajakPatientTO = patientService.create(kamilKajakPatientTO);

        // then

    }
}