package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;
import com.healthconnection.application.secondaryports.mapper.MapperEntity;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;


@Mapper(componentModel = "spring")
public interface IdentificationTypeMapperEntity extends MapperEntity<IdentificationTypeEntity, IdentificationTypeDomain>{

	IdentificationTypeEntity toEntity(IdentificationTypeDomain domain);
	
	IdentificationTypeDomain toDomain(IdentificationTypeEntity entity);
	
}
