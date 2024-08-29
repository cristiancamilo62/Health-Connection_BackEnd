package com.healthconnection.application.usecase.healthprofessional.validator.rules;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.patient.exceptions.EmptyEmailPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.InvalidFormatEmailPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthEmailPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.domain.healthprofessional.rules.validators.EmailHealthProfessionalRuleValidator;

@Service
public class EmailHealthProfessionalRuleValidatorImpl implements EmailHealthProfessionalRuleValidator{

	@Override
	public final void execute(final String email) {
		validateAbligatory(email);
		validateLength(email);
		validateFormat(email);
		
	}
	
	private final void validateAbligatory(final String email) {
		if(TextHelper.isEmpty(email)) {
			throw new EmptyEmailPatientRuleValidatorException();
		}
	}
	
	private final void validateLength(final String email) {
		if(!TextHelper.isValidLength(email, 11, 40)) {
			throw new LengthEmailPatientRuleValidatorException();
		}
	}
	
	private final void validateFormat(final String email) {
		if(!TextHelper.containsOnlyLettersDigitsAtDomain(email)) {
			throw new InvalidFormatEmailPatientRuleValidatorException();
		}
	}

}
