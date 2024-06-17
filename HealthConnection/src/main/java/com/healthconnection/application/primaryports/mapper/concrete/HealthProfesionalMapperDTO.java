package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.primaryports.dto.HealthProfessionalDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Mapper(componentModel = "spring")
public interface HealthProfesionalMapperDTO extends MapperDTO<HealthProfessionalDTO, HealthProfessionalDomain>{
	
	HealthProfessionalDomain toDomain(HealthProfessionalDTO dto);
	
	HealthProfessionalDTO toDTO(HealthProfessionalDomain domain);

}
