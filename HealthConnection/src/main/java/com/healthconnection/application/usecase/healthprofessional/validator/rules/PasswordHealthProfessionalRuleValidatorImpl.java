package com.healthconnection.application.usecase.healthprofessional.validator.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.exceptions.EmptyPasswordPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.InvalidFormatPasswordPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthPasswordPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.domain.healthprofessional.rules.validators.PasswordHealthProfessionalRuleValidator;

@Service
public class PasswordHealthProfessionalRuleValidatorImpl implements PasswordHealthProfessionalRuleValidator{

	@Override
	public final void execute(final String password) {
		
		validateAbligatory(password);
		validateLength(password);
		validateFormat(password);
		
	}
	
	private final void validateAbligatory(final String password) {
		if(TextHelper.isEmpty(password)) {
			throw new EmptyPasswordPatientRuleValidatorException();
		}
	}
	
	private final void validateLength(final String password) {
		if(!TextHelper.isValidLength(password, 8, 60)) {
			throw new LengthPasswordPatientRuleValidatorException();
		}
	}
	
	private final void validateFormat(final String password) {
	    boolean isValid = TextHelper.isValidPassword(password);
	    if (!isValid) {
	        throw new InvalidFormatPasswordPatientRuleValidatorException();
	    }
	}


}
