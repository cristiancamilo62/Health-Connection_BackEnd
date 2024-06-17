package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.primaryports.dto.ServiceTypeDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.servicetype.ServiceTypeDomain;

@Mapper(componentModel = "spring")
public interface ServiceTypeMapperDTO extends MapperDTO<ServiceTypeDTO, ServiceTypeDomain>{

	ServiceTypeDomain toDomain(ServiceTypeDTO dto);
	
	ServiceTypeDTO toDTO(ServiceTypeDomain domain);
	
}
