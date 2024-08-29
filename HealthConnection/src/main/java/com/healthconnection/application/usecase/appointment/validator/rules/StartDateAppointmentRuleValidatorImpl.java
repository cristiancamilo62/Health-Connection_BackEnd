package com.healthconnection.application.usecase.appointment.validator.rules;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.appointment.exceptions.EmptyStartDateAppointmentRuleValidatorexception;
import com.healthconnection.application.usecase.appointment.exceptions.InvalidFormatStartDateAppointmentRuleValidatorException;
import com.healthconnection.crosscutting.helper.DateHelper;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.domain.appointment.rules.validators.StartDateAppointmentRuleValidator;

@Service
public class StartDateAppointmentRuleValidatorImpl implements StartDateAppointmentRuleValidator {

	@Override
	public void execute(LocalDateTime data) {
		
		validateAbligatory(data);
		validateFormat(data);
		
	}

	private void validateFormat(LocalDateTime date) {
		
		var dateString = DateHelper.formatDateTime(date);
		
		if(!DateHelper.isValidDateTime(dateString)) {
			throw new InvalidFormatStartDateAppointmentRuleValidatorException();
		}
		
	}

	private void validateAbligatory(LocalDateTime date) {
		
		if(ObjectHelper.isEmpty(date)) {
			throw new EmptyStartDateAppointmentRuleValidatorexception();
		}
		
	}

}
