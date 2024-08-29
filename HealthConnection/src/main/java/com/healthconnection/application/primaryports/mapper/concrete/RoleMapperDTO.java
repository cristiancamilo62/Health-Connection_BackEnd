package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.primaryports.dto.RoleDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.role.RoleDomain;

@Mapper(componentModel = "spring")
public interface RoleMapperDTO extends MapperDTO<RoleDTO, RoleDomain>{
	
	RoleDomain toDomain(RoleDTO dto);
	
	RoleDTO toDTO(RoleDomain domain);

}
