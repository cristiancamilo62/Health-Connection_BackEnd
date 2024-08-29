package com.healthconnection.application.usecase.patient.exceptions;

import com.healthconnection.crosscutting.exception.custom.UseCaseHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

public class EmptyDateBirthPatientRuleValidatorException extends UseCaseHealthException{

	private static final long serialVersionUID = 1L;

	public EmptyDateBirthPatientRuleValidatorException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000042));
	}

}
