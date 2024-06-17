package com.healthconnection.application.usecase.appointment.exceptions;

import com.healthconnection.crosscutting.exception.custom.DomainHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

public class StartDateDoesNotBeforeEndDateAppointmentException extends DomainHealthException{

	private static final long serialVersionUID = 1L;

	public StartDateDoesNotBeforeEndDateAppointmentException() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000011));
	}
	
	

}
