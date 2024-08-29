package com.healthconnection.application.primaryports.interactor.appointment.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.AppointmentDTO;
import com.healthconnection.application.primaryports.interactor.appointment.ConsultAppointmentInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.AppointmentMapperDTO;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.usecase.appointment.ConsultAppointmentUseCase;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Service
public class ConsultAppointmentInteractorImpl implements ConsultAppointmentInteractor{

	private final  AppointmentMapperDTO appointmentMapperDTO;
	private final ConsultAppointmentUseCase consultAppointmentUseCase;
	

	public ConsultAppointmentInteractorImpl(AppointmentMapperDTO appointmentMapperDTO,
			ConsultAppointmentUseCase consultAppointmentUseCase) {
		super();
		this.appointmentMapperDTO = appointmentMapperDTO;
		this.consultAppointmentUseCase = consultAppointmentUseCase;
	}


	@Override
	public List<AppointmentEntity> execute(AppointmentDTO appointmentDTO) {
		
		AppointmentDomain appointmentDomain = appointmentMapperDTO.toDomain(appointmentDTO);
		
		List<AppointmentEntity> appointmentEntities = consultAppointmentUseCase.execute(appointmentDomain);
		
		return appointmentEntities.stream().toList();
	}

}
