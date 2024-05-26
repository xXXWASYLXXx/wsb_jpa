package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.modelmapper.ModelMapper;

public class PatientMapper {
    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(patientEntity, PatientTO.class);
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(patientTO, PatientEntity.class);
    }
}
