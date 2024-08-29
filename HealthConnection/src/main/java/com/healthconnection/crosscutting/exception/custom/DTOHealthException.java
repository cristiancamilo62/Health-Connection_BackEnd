package com.healthconnection.crosscutting.exception.custom;

import com.healthconnection.crosscutting.exception.HealthException;
import com.healthconnection.crosscutting.exception.enums.LocationException;

public class DTOHealthException extends HealthException {

	private static final long serialVersionUID = 1L;
	private static final LocationException location = LocationException.DTO;

	public DTOHealthException(final String userMessage) {
		super(userMessage, location);
	}

	public DTOHealthException(final String technicalMessage, final String userMessage) {
		super(technicalMessage, userMessage, location);
	}

	public DTOHealthException(final String technicalMessage, final String userMessage,
			final Throwable rootException) {
		super(technicalMessage, userMessage, location, rootException);
	}
}
