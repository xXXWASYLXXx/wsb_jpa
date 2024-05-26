package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {
    PatientEntity findByLastName(String last);
    List<PatientEntity> findVipPatients();
    List<PatientEntity> findPatientsWithExpectedVisits(long expectedVisits);
}
