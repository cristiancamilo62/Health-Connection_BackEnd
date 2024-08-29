package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.primaryports.dto.EpsDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.eps.EpsDomain;

@Mapper(componentModel = "spring")
public interface EpsMapperDTO extends MapperDTO<EpsDTO, EpsDomain>{
	
	EpsDTO toDTO(EpsDomain domain);
	
	EpsDomain toDomain(EpsDTO dto);

}
