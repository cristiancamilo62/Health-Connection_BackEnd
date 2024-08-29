package com.healthconnection.application.usecase.healthprofessional.exceptions;

import com.healthconnection.crosscutting.exception.custom.UseCaseHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

public class DefaultIdHealthProfessionalRuleValidatorException extends UseCaseHealthException{

	 
	private static final long serialVersionUID = 1L;

	public DefaultIdHealthProfessionalRuleValidatorException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000062));
	}

}
