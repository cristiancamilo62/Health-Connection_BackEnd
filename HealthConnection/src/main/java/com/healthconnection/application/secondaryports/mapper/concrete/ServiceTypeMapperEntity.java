package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.secondaryports.entity.ServiceTypeEntity;
import com.healthconnection.application.secondaryports.mapper.MapperEntity;
import com.healthconnection.domain.servicetype.ServiceTypeDomain;

@Mapper(componentModel = "spring")
public interface ServiceTypeMapperEntity extends MapperEntity<ServiceTypeEntity, ServiceTypeDomain>{
	
	ServiceTypeDomain toDomain(ServiceTypeEntity entity);
	
	ServiceTypeEntity toEntity(ServiceTypeDomain domain);

}
