package com.healthconnection.application.usecase.appointment.validator.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.appointment.validator.RegisterAppointmentRuleValidator;
import com.healthconnection.domain.appointment.AppointmentDomain;
import com.healthconnection.domain.appointment.rules.validators.AppointmentRuleValidator;
import com.healthconnection.domain.appointment.rules.validators.EndDateAppointmentRuleValidator;
import com.healthconnection.domain.appointment.rules.validators.IdAppointmentRuleValidator;
import com.healthconnection.domain.appointment.rules.validators.StartDateAppointmentRuleValidator;

@Service
public class RegisterAppointmentRuleValidatorImpl implements RegisterAppointmentRuleValidator{

	private final AppointmentRuleValidator appointmentRuleValidator;
	private final IdAppointmentRuleValidator idAppointmentRuleValidator;
	private final StartDateAppointmentRuleValidator startDateAppointmentRuleValidator;
	private final EndDateAppointmentRuleValidator endDateAppointmentRuleValidator;
	
	public RegisterAppointmentRuleValidatorImpl(AppointmentRuleValidator appointmentRuleValidator,
			IdAppointmentRuleValidator idAppointmentRuleValidator,
			StartDateAppointmentRuleValidator startDateAppointmentRuleValidator,
			EndDateAppointmentRuleValidator endDateAppointmentRuleValidator) {
		super();
		this.appointmentRuleValidator = appointmentRuleValidator;
		this.idAppointmentRuleValidator = idAppointmentRuleValidator;
		this.startDateAppointmentRuleValidator = startDateAppointmentRuleValidator;
		this.endDateAppointmentRuleValidator = endDateAppointmentRuleValidator;
	}



	@Override
	public void validate(AppointmentDomain appointment) {
	
		appointmentRuleValidator.execute(appointment);
		
		idAppointmentRuleValidator.execute(appointment.getId());
		
		startDateAppointmentRuleValidator.execute(appointment.getStartDate());
		
		endDateAppointmentRuleValidator.execute(appointment.getEndDate());
		
	}

}
