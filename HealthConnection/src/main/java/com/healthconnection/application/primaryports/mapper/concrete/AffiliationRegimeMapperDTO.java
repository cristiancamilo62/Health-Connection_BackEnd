package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.primaryports.dto.AffiliationRegimeDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.affiliationregime.AffiliationRegimeDomain;

@Mapper(componentModel = "spring")
public interface AffiliationRegimeMapperDTO extends MapperDTO<AffiliationRegimeDTO, AffiliationRegimeDomain>{
	
	AffiliationRegimeDomain toDomain(AffiliationRegimeDTO dto);
	
	AffiliationRegimeDTO toDTO(AffiliationRegimeDomain domain);

}
