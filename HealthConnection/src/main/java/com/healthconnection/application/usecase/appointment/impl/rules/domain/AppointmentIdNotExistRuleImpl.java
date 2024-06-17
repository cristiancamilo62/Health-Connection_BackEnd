package com.healthconnection.application.usecase.appointment.impl.rules.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.repository.concrete.appointment.AppointmentRepository;
import com.healthconnection.application.usecase.appointment.exceptions.AppointmentIdNotExistExeption;
import com.healthconnection.domain.appointment.rules.AppointmentIdDoesNotExistRule;


@Service
public class AppointmentIdNotExistRuleImpl implements AppointmentIdDoesNotExistRule{

	private AppointmentRepository appointmentRepository;
	
	public AppointmentIdNotExistRuleImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}



	@Override
	public void execute(UUID id) {
		
		var results = appointmentRepository.findById(id);
		
		if(!results.isEmpty()) {
			throw new AppointmentIdNotExistExeption();
		}
		
	}

}
