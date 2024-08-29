package com.healthconnection.application.usecase.appointment.validator.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.appointment.exceptions.NullAppointmentRuleValidatorException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.domain.appointment.AppointmentDomain;
import com.healthconnection.domain.appointment.rules.validators.AppointmentRuleValidator;

@Service
public class AppointmentRuleValidatorImpl implements AppointmentRuleValidator{

	@Override
	public void execute(AppointmentDomain data) {
		
		if(ObjectHelper.isNull(data)) {
			throw new NullAppointmentRuleValidatorException();
		}
		
	}
	 

}
