package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.mapper.PatientMapper;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
    private final PatientDao patientDao;

    @Autowired
    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public PatientTO findById(Long id) {
        PatientEntity entity = patientDao.findOne(id);
        return PatientMapper.mapToTO(entity);
    }

    @Override
    public PatientTO create(PatientTO patientTO) {
        PatientEntity patientEntity = PatientMapper.mapToEntity(patientTO);
        PatientEntity savedPatientEntity = patientDao.save(patientEntity);
        return PatientMapper.mapToTO(savedPatientEntity);
    }

    @Override
    public void deleteById(Long id) {
        PatientEntity patientEntity = patientDao.findOne(id);
        patientDao.delete(patientEntity);
    }
}
