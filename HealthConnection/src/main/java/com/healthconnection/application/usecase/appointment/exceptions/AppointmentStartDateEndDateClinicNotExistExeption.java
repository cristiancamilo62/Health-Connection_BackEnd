package com.healthconnection.application.usecase.appointment.exceptions;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.exception.custom.DomainHealthException;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

@Service
public class AppointmentStartDateEndDateClinicNotExistExeption extends DomainHealthException{

	private static final long serialVersionUID = 1L;

	public AppointmentStartDateEndDateClinicNotExistExeption() {
		super(MessageCatalog.getContentMessage(MessageCode.M0000009));
	}
	
	

}
