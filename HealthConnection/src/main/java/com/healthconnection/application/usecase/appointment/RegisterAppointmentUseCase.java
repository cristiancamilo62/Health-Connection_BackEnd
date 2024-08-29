package com.healthconnection.application.usecase.appointment;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.appointment.AppointmentDomain;

@Service
public interface RegisterAppointmentUseCase {
	
	void execute(AppointmentDomain appointmentDomain);

}
