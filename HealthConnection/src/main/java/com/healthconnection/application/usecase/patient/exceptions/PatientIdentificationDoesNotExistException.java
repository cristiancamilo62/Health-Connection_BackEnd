package com.healthconnection.application.usecase.patient.exceptions;


import org.springframework.stereotype.Service;
import com.healthconnection.crosscutting.exception.custom.DomainHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

@Service
public class PatientIdentificationDoesNotExistException extends DomainHealthException{

	private static final long serialVersionUID = 1L;

	public PatientIdentificationDoesNotExistException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000006));
	}

}
