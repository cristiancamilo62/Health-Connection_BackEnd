package com.healthconnection.application.usecase.identificationtype.validator.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.identificationtype.exceptions.DefaultIdIdentificationTypeRuleValidatorException;
import com.healthconnection.application.usecase.identificationtype.exceptions.NullIdIdentificationTypeRuleValidatorException;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.identificationtype.rules.validators.IdIdentificationTypeRuleValidator;

@Service
public class IdIdentificationTypeRuleValidatorImpl implements IdIdentificationTypeRuleValidator{

	@Override
	public final void execute(final UUID data) {
		validateIdNull(data);
		validateIdDefault(data);
		
	}
	
	private final void validateIdDefault(final UUID id) {
		if(UuidHelper.isDefault(id)) {
			throw new DefaultIdIdentificationTypeRuleValidatorException();
		}
	}
	
	private final void validateIdNull(final UUID id) {
		if(UuidHelper.isUuidNull(id)) {
			throw new NullIdIdentificationTypeRuleValidatorException();
		}
	}

}
