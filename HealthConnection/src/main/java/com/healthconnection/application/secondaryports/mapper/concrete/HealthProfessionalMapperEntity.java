package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;
import com.healthconnection.application.secondaryports.mapper.MapperEntity;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Mapper(componentModel = "spring")
public interface HealthProfessionalMapperEntity extends MapperEntity<HealthProfessionalEntity, HealthProfessionalDomain>{
	
	HealthProfessionalDomain toDomain(HealthProfessionalEntity dto);
	
	HealthProfessionalEntity toEntity(HealthProfessionalDomain domain);

}
