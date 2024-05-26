package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.MedicalTreatmentTO;
import com.capgemini.wsb.persistence.entity.MedicalTreatmentEntity;

import java.util.Set;
import java.util.stream.Collectors;

public final class MedicalTreatmentMapper {
    public static MedicalTreatmentTO mapToTO(final MedicalTreatmentEntity medicalTreatmentEntity) {
        if (medicalTreatmentEntity == null) {
            return null;
        }
        final MedicalTreatmentTO medicalTreatmentTO = new MedicalTreatmentTO();
        medicalTreatmentTO.setId(medicalTreatmentEntity.getId());
        medicalTreatmentTO.setDescription(medicalTreatmentEntity.getDescription());
        medicalTreatmentTO.setType(medicalTreatmentEntity.getType());
        return medicalTreatmentTO;
    }

    public static MedicalTreatmentEntity mapToEntity(final MedicalTreatmentTO medicalTreatmentTO) {
        if (medicalTreatmentTO == null) {
            return null;
        }
        MedicalTreatmentEntity medicalTreatmentEntity = new MedicalTreatmentEntity();
        medicalTreatmentEntity.setId(medicalTreatmentTO.getId());
        medicalTreatmentEntity.setDescription(medicalTreatmentTO.getDescription());
        medicalTreatmentEntity.setType(medicalTreatmentTO.getType());
        return medicalTreatmentEntity;
    }

    public static Set<MedicalTreatmentTO> map2TOs(final Set<MedicalTreatmentEntity> medicalTreatmentEntities) {
        return medicalTreatmentEntities.stream().map(MedicalTreatmentMapper::mapToTO).collect(Collectors.toSet());
    }

    public static Set<MedicalTreatmentEntity> map2Entities(final Set<MedicalTreatmentTO> medicalTreatmentTOs) {
        return medicalTreatmentTOs.stream().map(MedicalTreatmentMapper::mapToEntity).collect(Collectors.toSet());
    }
}
