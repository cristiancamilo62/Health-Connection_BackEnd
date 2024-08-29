package com.healthconnection.application.usecase.healthprofessional.validator.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.exceptions.InvalidFirstNameFormatPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.InvalidLastNameFormatPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.InvalidMiddleNameFormatPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthFirstNamePatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthLastNamePatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthMiddleLastNamePatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.LengthMiddleNamePatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.NullOrEmptyFirstnamePatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.NullOrEmptyLastNamePatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;
import com.healthconnection.domain.healthprofessional.rules.validators.NameHealthProfessionalRuleValidator;


@Service
public class NameHealthProfessionalRuleValidatorImpl implements NameHealthProfessionalRuleValidator{

	
	@Override
	public final void execute(final HealthProfessionalDomain data) {
			validateAbligatory(data);
			validateLength(data);
			validateFormat(data);
		}
	
	
	private final void validateAbligatory(final HealthProfessionalDomain healthProfessionalDomain) {
		validateAbligatoryFirstName(healthProfessionalDomain.getFirstName());
		validateAbligatoryLastName(healthProfessionalDomain.getLastName());
	}
	
	private final void validateLength(final HealthProfessionalDomain healthProfessionalDomain) {
		validateLengthFirstName(healthProfessionalDomain.getFirstName());
		validateLengthMiddleName(healthProfessionalDomain.getMiddleName());
		validateLengthLastName(healthProfessionalDomain.getLastName());
		validateLengthMiddleLastName(healthProfessionalDomain.getMiddleLastName());
		
		
	}
	private final void validateFormat(final HealthProfessionalDomain healthProfessionalDomain) {
		validateFormatFirstName(healthProfessionalDomain.getFirstName());
		validateFormatMiddleName(healthProfessionalDomain.getMiddleName());
		validateFormatLastName(healthProfessionalDomain.getLastName());
		validateFormatMiddleLastName(healthProfessionalDomain.getMiddleLastName());
		
	}
	
	private final void validateAbligatoryFirstName(final String firstName) {
		if(TextHelper.isNullOrEmpty(firstName)) {
			throw new NullOrEmptyFirstnamePatientRuleValidatorException();
		}
	}
	private final void validateAbligatoryLastName(final String middleLastName) {
		if(TextHelper.isNullOrEmpty(middleLastName)) {
			throw new NullOrEmptyLastNamePatientRuleValidatorException();
		}
	}
	private final void validateLengthFirstName(final String firstName) {
		if(!TextHelper.isValidMaximumLength(firstName, 12)) {
			throw new LengthFirstNamePatientRuleValidatorException();
		}
	}
	private final void validateLengthMiddleName(final String middleName) {
		if(!TextHelper.isEmpty(middleName) && !TextHelper.isValidMaximumLength(middleName, 12)) {
			throw new LengthMiddleNamePatientRuleValidatorException();
		}
	}
	private final void validateLengthLastName(final String lastName) {
		if(!TextHelper.isValidMaximumLength(lastName, 12)) {
			throw new LengthLastNamePatientRuleValidatorException();
		}
	}
	
	private final void validateLengthMiddleLastName(final String middleLastName) {
		if(!TextHelper.isEmpty(middleLastName) && !TextHelper.isValidMaximumLength(middleLastName, 12)) {
			throw new LengthMiddleLastNamePatientRuleValidatorException();
		}
	}
	private final void validateFormatFirstName(final String firstName) {
		if(!TextHelper.containsOnlyLettersDigits(firstName)) {
			throw new InvalidFirstNameFormatPatientRuleValidatorException();
		}
	}
	private final void validateFormatMiddleName(final String middleName) {
		if(!TextHelper.isEmpty(middleName) && !TextHelper.containsOnlyLettersDigits(middleName)) {
			throw new InvalidMiddleNameFormatPatientRuleValidatorException();
		}
	}
	private final void validateFormatLastName(final String lastName) {
		if(!TextHelper.containsOnlyLettersDigits(lastName)) {
			throw new InvalidLastNameFormatPatientRuleValidatorException();
		}
	}
	private final void validateFormatMiddleLastName(final String middleLastName) {
		if(!TextHelper.isEmpty(middleLastName) && !TextHelper.containsOnlyLettersDigits(middleLastName)) {
			throw new InvalidMiddleNameFormatPatientRuleValidatorException();
		}
	}
}
