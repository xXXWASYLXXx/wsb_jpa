package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.VisitEntity;

public final class VisitMapper {
    public static VisitTO mapToTO(final VisitEntity visitEntity) {
        if (visitEntity == null) {
            return null;
        }
        final VisitTO visitTO = new VisitTO();
        visitTO.setId(visitEntity.getId());
        visitTO.setDescription(visitEntity.getDescription());
        visitTO.setTime(visitEntity.getTime());
        visitTO.setDoctor(DoctorMapper.mapToTO(visitEntity.getDoctor()));
        visitTO.setPatient(PatientMapper.mapToTO(visitEntity.getPatient()));
        visitTO.setMedicalTreatments(MedicalTreatmentMapper.map2TOs(visitEntity.getMedicalTreatments()));
        return visitTO;
    }

    public static VisitEntity mapToEntity(final VisitTO visitTO) {
        if (visitTO == null) {
            return null;
        }
        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(visitTO.getId());
        visitEntity.setDescription(visitTO.getDescription());
        visitEntity.setTime(visitTO.getTime());
        visitEntity.setDoctor(DoctorMapper.mapToEntity(visitTO.getDoctor()));
        visitEntity.setPatient(PatientMapper.mapToEntity(visitTO.getPatient()));
        visitEntity.setMedicalTreatments(MedicalTreatmentMapper.map2Entities(visitTO.getMedicalTreatments()));
        return visitEntity;
    }
}
