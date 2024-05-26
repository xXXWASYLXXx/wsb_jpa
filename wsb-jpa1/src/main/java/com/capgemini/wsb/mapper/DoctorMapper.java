package com.capgemini.wsb.mapper;

import com.capgemini.wsb.dto.DoctorTO;
import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.modelmapper.ModelMapper;

public class DoctorMapper {
    public static DoctorTO mapToTO(final DoctorEntity doctorEntity) {
        if (doctorEntity == null) {
            return null;
        }
        final DoctorTO doctorTO = new DoctorTO();
        doctorTO.setId(doctorEntity.getId());
        doctorTO.setFirstName(doctorEntity.getFirstName());
        doctorTO.setLastName(doctorEntity.getLastName());
        doctorTO.setTelephoneNumber(doctorEntity.getTelephoneNumber());
        doctorTO.setEmail(doctorEntity.getEmail());
        doctorTO.setSpecialization(doctorEntity.getSpecialization());
        ModelMapper modelMapper = new ModelMapper();
        doctorEntity.getVisits().forEach(
                visitEntity -> doctorTO.addVisit(modelMapper.map(visitEntity, VisitTO.class)));
        doctorTO.setAddress(AddressMapper.mapToTO(doctorEntity.getAddress()));
        return doctorTO;
    }

    public static DoctorEntity mapToEntity(final DoctorTO doctorTO) {
        if (doctorTO == null) {
            return null;
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctorTO.getId());
        doctorEntity.setFirstName(doctorTO.getFirstName());
        doctorEntity.setLastName(doctorTO.getLastName());
        doctorEntity.setTelephoneNumber(doctorTO.getTelephoneNumber());
        doctorEntity.setEmail(doctorTO.getEmail());
        doctorEntity.setSpecialization(doctorTO.getSpecialization());
        ModelMapper modelMapper = new ModelMapper();
        doctorTO.getVisits().forEach(
                visitTO -> doctorEntity.addVisit(modelMapper.map(visitTO, VisitEntity.class)));
        doctorEntity.setAddress(AddressMapper.mapToEntity(doctorTO.getAddress()));
        return doctorEntity;
    }
}
