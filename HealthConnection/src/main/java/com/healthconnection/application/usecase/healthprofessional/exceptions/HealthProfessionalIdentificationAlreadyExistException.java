package com.healthconnection.application.usecase.healthprofessional.exceptions;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.exception.custom.UseCaseHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

@Service
public class HealthProfessionalIdentificationAlreadyExistException extends UseCaseHealthException {

	private static final long serialVersionUID = 1L;

	public HealthProfessionalIdentificationAlreadyExistException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000060));
	}

}
