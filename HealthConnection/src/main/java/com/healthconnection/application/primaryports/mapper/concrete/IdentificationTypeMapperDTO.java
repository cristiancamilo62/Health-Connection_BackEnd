package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.primaryports.dto.IdentificationTypeDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;


@Mapper(componentModel = "spring")
public interface IdentificationTypeMapperDTO extends MapperDTO<IdentificationTypeDTO, IdentificationTypeDomain>{
	
	IdentificationTypeDTO toDTO(IdentificationTypeDomain domain);
	
	IdentificationTypeDomain toDomain(IdentificationTypeDTO dto);

}
