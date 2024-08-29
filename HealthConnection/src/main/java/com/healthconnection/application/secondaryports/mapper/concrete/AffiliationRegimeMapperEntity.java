package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.secondaryports.entity.AffiliationRegimeEntity;
import com.healthconnection.application.secondaryports.mapper.MapperEntity;
import com.healthconnection.domain.affiliationregime.AffiliationRegimeDomain;

@Mapper(componentModel = "spring")
public interface AffiliationRegimeMapperEntity extends MapperEntity<AffiliationRegimeEntity, AffiliationRegimeDomain>{

	AffiliationRegimeDomain toDomain(AffiliationRegimeEntity entity);
	
	AffiliationRegimeEntity toEntity(AffiliationRegimeDomain domain);
	
}
