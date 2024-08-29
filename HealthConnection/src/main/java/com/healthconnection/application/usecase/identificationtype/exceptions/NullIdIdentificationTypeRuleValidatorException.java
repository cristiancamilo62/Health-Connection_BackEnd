package com.healthconnection.application.usecase.identificationtype.exceptions;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.exception.custom.UseCaseHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

@Service
public class NullIdIdentificationTypeRuleValidatorException extends UseCaseHealthException{

	private static final long serialVersionUID = 1L;

	public NullIdIdentificationTypeRuleValidatorException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000047));
		// TODO Auto-generated constructor stub
	}

}
