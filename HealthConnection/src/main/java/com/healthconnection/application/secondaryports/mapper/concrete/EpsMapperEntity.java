package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.secondaryports.entity.EpsEntity;
import com.healthconnection.application.secondaryports.mapper.MapperEntity;
import com.healthconnection.domain.eps.EpsDomain;


@Mapper(componentModel = "spring")
public interface EpsMapperEntity extends MapperEntity<EpsEntity, EpsDomain>{
	
	EpsEntity toEntity(EpsDomain domain);
	
	EpsDomain toDomain(EpsEntity entity);

}
