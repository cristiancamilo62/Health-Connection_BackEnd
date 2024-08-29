package com.healthconnection.application.usecase.patient.validator.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.exceptions.InvalidFormatPhoneNumberPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthPhoneNumberPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.domain.patient.rules.validators.PhoneNumberPatientRuleValidator;

@Service
public class PhoneNumberPatientRuleValidatorImpl implements PhoneNumberPatientRuleValidator{

	@Override
	public final void execute(final String phoneNumber) {
		validateLength(phoneNumber);
		validateFormat(phoneNumber);
	}

	
	private final void validateLength(final String phoneNumber) {
		if(!TextHelper.isEmpty(phoneNumber) && !TextHelper.isExactLength(phoneNumber, 10)) {
			throw new LengthPhoneNumberPatientRuleValidatorException();
		}
	}
	
	private final void validateFormat(final String phoneNumber) {
		if(!TextHelper.isEmpty(phoneNumber) && !TextHelper.containsOnlyDigits(phoneNumber)) {
			throw new InvalidFormatPhoneNumberPatientRuleValidatorException();
		}
	}

}
