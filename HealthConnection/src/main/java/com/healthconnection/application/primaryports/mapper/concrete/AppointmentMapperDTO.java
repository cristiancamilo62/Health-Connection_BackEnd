package com.healthconnection.application.primaryports.mapper.concrete;

import org.mapstruct.Mapper;
import com.healthconnection.application.primaryports.dto.AppointmentDTO;
import com.healthconnection.application.primaryports.mapper.MapperDTO;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Mapper(componentModel = "spring")
public interface AppointmentMapperDTO extends MapperDTO<AppointmentDTO, AppointmentDomain>{

	AppointmentDomain toDomain(AppointmentDTO dto);
	
	AppointmentDTO toDTO(AppointmentDomain domain);
}
