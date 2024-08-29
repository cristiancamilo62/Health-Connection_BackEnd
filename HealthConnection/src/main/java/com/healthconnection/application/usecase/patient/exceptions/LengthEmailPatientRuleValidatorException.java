package com.healthconnection.application.usecase.patient.exceptions;

import com.healthconnection.crosscutting.exception.custom.UseCaseHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

public class LengthEmailPatientRuleValidatorException extends UseCaseHealthException{

	private static final long serialVersionUID = 1L;

	public LengthEmailPatientRuleValidatorException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000035));
	
	}

}
