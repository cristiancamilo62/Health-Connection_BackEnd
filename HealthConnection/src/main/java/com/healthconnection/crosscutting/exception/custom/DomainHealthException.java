package com.healthconnection.crosscutting.exception.custom;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.exception.HealthException;
import com.healthconnection.crosscutting.exception.enums.LocationException;

@Service
public class DomainHealthException extends HealthException {

	private static final long serialVersionUID = 1L;
	private static final LocationException location = LocationException.DOMAIN;
	
	  public DomainHealthException() {
	        super(location);
	    }

	public DomainHealthException(final String userMessage) {
		super(userMessage, location);
	}

	public DomainHealthException(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, location);
	}

	public DomainHealthException(final String technicalMessage, final String userMessage,
			final Throwable rootException) {
		super(technicalMessage, userMessage, location, rootException);
	}
}
