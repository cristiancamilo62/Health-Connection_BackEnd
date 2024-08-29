package com.healthconnection.application.usecase.appointment.validator.rules;

import java.util.UUID;
import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.appointment.exceptions.DefaultIdAppointmentRuleValidatorException;
import com.healthconnection.application.usecase.appointment.exceptions.EmptyIdAppointmentRuleValidatorException;
import com.healthconnection.application.usecase.appointment.exceptions.NullIdAppointmentRuleValidatorException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.appointment.rules.validators.IdAppointmentRuleValidator;

@Service
public class IdAppointmentRuleValidatorImpl implements IdAppointmentRuleValidator{

	@Override
	public void execute(UUID data) {
		validateIdDefault(data);
		validateIdEmpty(data);
		validateIdNull(data);
		
	}
	
	private void validateIdDefault(UUID id) {
		if(UuidHelper.isDefault(id)) {
			throw new DefaultIdAppointmentRuleValidatorException();
		}
	}
	
	private void validateIdNull(UUID id) {
		if(ObjectHelper.isNull(id)) {
			throw new NullIdAppointmentRuleValidatorException();
		}
	}
	
	private void validateIdEmpty(UUID id) {
		if(ObjectHelper.isEmpty(id)) {
			throw new EmptyIdAppointmentRuleValidatorException();
		}
	}
	
	

}
