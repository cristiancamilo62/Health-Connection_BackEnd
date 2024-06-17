package com.healthconnection.application.usecase.auth.exceptions;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.exception.custom.DomainHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

@Service
public class PatientNotRegisterException extends DomainHealthException{

	private static final long serialVersionUID = 1L;

	public PatientNotRegisterException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000013));
	}
	

}
