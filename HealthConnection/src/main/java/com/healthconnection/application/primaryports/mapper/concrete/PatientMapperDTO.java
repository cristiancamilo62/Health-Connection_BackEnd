package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.patient.PatientDomain;

@Mapper(componentModel = "spring")
public interface PatientMapperDTO extends MapperDTO<PatientDTO, PatientDomain> {
   
	PatientDomain toDomain(PatientDTO dto);
	
    PatientDTO toDTO(PatientDomain domain);
}
