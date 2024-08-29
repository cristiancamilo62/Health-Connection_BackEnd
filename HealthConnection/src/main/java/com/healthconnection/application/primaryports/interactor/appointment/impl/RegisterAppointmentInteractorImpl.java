package com.healthconnection.application.primaryports.interactor.appointment.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.AppointmentDTO;
import com.healthconnection.application.primaryports.interactor.appointment.RegisterAppointmentInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.AppointmentMapperDTO;
import com.healthconnection.application.usecase.appointment.RegisterAppointmentUseCase;

@Service
public class RegisterAppointmentInteractorImpl implements RegisterAppointmentInteractor{

	
	private AppointmentMapperDTO appointmentMapperDTO;
	private RegisterAppointmentUseCase registerAppointmentUseCase;
	
	public RegisterAppointmentInteractorImpl(AppointmentMapperDTO appointmentMapperDTO,
			RegisterAppointmentUseCase registerAppointmentUseCase) {
		this.appointmentMapperDTO = appointmentMapperDTO;
		this.registerAppointmentUseCase = registerAppointmentUseCase;
	}


	@Override
	public void execute(AppointmentDTO appointmen) {
		
		var appointmentDomain =  appointmentMapperDTO.toDomain(appointmen);
		
		registerAppointmentUseCase.execute(appointmentDomain);
		
	}

}
