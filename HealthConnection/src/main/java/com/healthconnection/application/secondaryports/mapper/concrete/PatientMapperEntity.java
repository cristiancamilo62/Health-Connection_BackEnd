package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.domain.patient.PatientDomain;

@Mapper(componentModel = "spring")
public interface PatientMapperEntity {
		
    PatientDomain toDomain(PatientEntity entity);
    
    PatientEntity toEntity(PatientDomain domain);
    

}
