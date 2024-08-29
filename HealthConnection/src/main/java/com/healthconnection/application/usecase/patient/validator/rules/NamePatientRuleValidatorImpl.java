package com.healthconnection.application.usecase.patient.validator.rules;

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
import com.healthconnection.domain.patient.PatientDomain;
import com.healthconnection.domain.patient.rules.validators.NamePatientRuleValidator;


@Service
public class NamePatientRuleValidatorImpl implements NamePatientRuleValidator{

	
	@Override
	public final void execute(final PatientDomain data) {
			validateAbligatory(data);
			validateLength(data);
			validateFormat(data);
		}
	
	
	private final void validateAbligatory(final PatientDomain patientDomain) {
		validateAbligatoryFirstName(patientDomain.getFirstName());
		validateAbligatoryLastName(patientDomain.getLastName());
	}
	
	private final void validateLength(final PatientDomain patientDomain) {
		validateLengthFirstName(patientDomain.getFirstName());
		validateLengthMiddleName(patientDomain.getMiddleName());
		validateLengthLastName(patientDomain.getLastName());
		validateLengthMiddleLastName(patientDomain.getMiddleLastName());
		
		
	}
	private final void validateFormat(final PatientDomain patientDomain) {
		validateFormatFirstName(patientDomain.getFirstName());
		validateFormatMiddleName(patientDomain.getMiddleName());
		validateFormatLastName(patientDomain.getLastName());
		validateFormatMiddleLastName(patientDomain.getMiddleLastName());
		
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
