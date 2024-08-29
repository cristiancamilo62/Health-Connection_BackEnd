package com.healthconnection.application.usecase.patient.exceptions;

import com.healthconnection.crosscutting.exception.custom.ControllerHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

public class EmptyPatientBodyException extends ControllerHealthException{
	
	private static final long serialVersionUID = 1L;

	public EmptyPatientBodyException() {
		
		super(MessageCatalog.getContentMessage(MessageCode.M0000016),
				MessageCatalog.getContentMessage(MessageCode.M0000015));
	}
}
