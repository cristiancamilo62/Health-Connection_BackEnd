package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;

import com.healthconnection.application.secondaryports.entity.RoleEntity;
import com.healthconnection.application.secondaryports.mapper.MapperEntity;
import com.healthconnection.domain.role.RoleDomain;

@Mapper(componentModel = "spring")
public interface RoleMapperEntity extends MapperEntity<RoleEntity, RoleDomain>{
	
	RoleDomain toDomain(RoleEntity entity);
	
	RoleEntity toEntity(RoleDomain domain);

}
