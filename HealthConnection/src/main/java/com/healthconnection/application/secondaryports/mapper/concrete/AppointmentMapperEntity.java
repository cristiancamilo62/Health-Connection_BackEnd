package com.healthconnection.application.secondaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.secondaryports.mapper.MapperEntity;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Mapper(componentModel = "spring")
public interface AppointmentMapperEntity extends MapperEntity<AppointmentEntity, AppointmentDomain>{
	
	AppointmentDomain toDomain(AppointmentEntity entity);
    
	AppointmentEntity toEntity(AppointmentDomain domain);

}
