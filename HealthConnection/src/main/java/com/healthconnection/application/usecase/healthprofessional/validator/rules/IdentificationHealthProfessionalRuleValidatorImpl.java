package com.healthconnection.application.usecase.healthprofessional.validator.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.exceptions.EmptyIdentificationPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.InvalidFormatIdentificationPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthIdentificationPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.domain.healthprofessional.rules.validators.IdentificationHealthProfessionalRuleValidator;

@Service
public class IdentificationHealthProfessionalRuleValidatorImpl implements IdentificationHealthProfessionalRuleValidator{

	
	@Override
	public final void execute(final String identification) {
		
		validateAbligatory(identification);
		validateLength(identification);
		validateFormat(identification);
		
	}
	
	private final void validateAbligatory(final String identification) {
		if(TextHelper.isEmpty(identification)) {
			throw new EmptyIdentificationPatientRuleValidatorException();
		}
	}
	
	private final void validateLength(final String identification) {
		if(!TextHelper.isExactLength(identification, 10)) {
			throw new LengthIdentificationPatientRuleValidatorException();
		}
	}
	
	private final void validateFormat(final String identificaction) {
		if(!TextHelper.containsOnlyDigits(identificaction)) {
			throw new InvalidFormatIdentificationPatientRuleValidatorException();
		}
	}

}
