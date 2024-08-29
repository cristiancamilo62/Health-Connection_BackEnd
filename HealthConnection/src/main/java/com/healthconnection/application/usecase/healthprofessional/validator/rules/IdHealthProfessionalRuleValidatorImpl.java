package com.healthconnection.application.usecase.healthprofessional.validator.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.exceptions.DefaultIdPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.NullIdPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.healthprofessional.rules.validators.IdHealthProfessionalRuleValidator;

@Service
public class IdHealthProfessionalRuleValidatorImpl implements IdHealthProfessionalRuleValidator{
	
	@Override
	public final void execute(final UUID data) {
		validateIdNull(data);
		validateIdDefault(data);
		
	}
	
	private final void validateIdDefault(final UUID id) {
		if(UuidHelper.isDefault(id)) {
			throw new DefaultIdPatientRuleValidatorException();
		}
	}
	
	private final void validateIdNull(final UUID id) {
		if(UuidHelper.isUuidNull(id)) {
			throw new NullIdPatientRuleValidatorException();
		}
	}



}
