package com.healthconnection.application.usecase.identificationtype.validator.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.identificationtype.exceptions.NullIdentificationTypeRuleValidatorException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;
import com.healthconnection.domain.identificationtype.rules.validators.IdentificationTypeRuleValidator;

@Service
public class IdentificationTypeRuleValidatorImpl implements IdentificationTypeRuleValidator{

	
	@Override
	public void execute(IdentificationTypeDomain identificationTypeDomain) {
		
		if(ObjectHelper.isNull(identificationTypeDomain)) {
			throw new NullIdentificationTypeRuleValidatorException();
		}
		
	}

}
