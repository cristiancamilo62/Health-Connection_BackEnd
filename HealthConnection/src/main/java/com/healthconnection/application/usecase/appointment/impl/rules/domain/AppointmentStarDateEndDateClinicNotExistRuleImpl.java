package com.healthconnection.application.usecase.appointment.impl.rules.domain;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.repository.concrete.appointment.AppointmentRepository;
import com.healthconnection.domain.appointment.AppointmentDomain;
import com.healthconnection.domain.appointment.rules.AppointmentStartDateEndDateClinicNotExistRule;

@Service
public class AppointmentStarDateEndDateClinicNotExistRuleImpl implements AppointmentStartDateEndDateClinicNotExistRule{

	private AppointmentRepository appointmentRepository;
	
	public AppointmentStarDateEndDateClinicNotExistRuleImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public void execute(AppointmentDomain appointmentDomain) {
		
		appointmentRepository.existsByStartDateAndEndDateAndAppointmentServiceDataClinic(appointmentDomain.getStartDate(),
				appointmentDomain.getEndDate(), appointmentDomain.getAppointmentServiceData().getClinic());
		
	}

	

}
