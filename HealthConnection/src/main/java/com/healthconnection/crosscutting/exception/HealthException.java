package com.healthconnection.crosscutting.exception;

import com.healthconnection.crosscutting.exception.enums.LocationException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;

public class HealthException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	protected String userMessage;
	protected LocationException locationException;
	
	

	public HealthException(LocationException locationException) {
		setLocationException(locationException);
	}

	public HealthException(String technicalMessage, String userMessage, LocationException locationException, Throwable rootException) {
		super(technicalMessage, rootException);
		setMensajeUsuario(userMessage);
		setLocationException(locationException);
	}

	public HealthException(final String userMessage, final LocationException locationException) {
		super(userMessage);
		setMensajeUsuario(userMessage);
		setLocationException(locationException);
	}

	public HealthException(String technicalMessage, String userMessage, LocationException locationException) {
		super(technicalMessage);
		setMensajeUsuario(userMessage);
		setLocationException(locationException);
	}

	private final void setMensajeUsuario(final String userMessage) {
		this.userMessage = TextHelper.applyTrim(userMessage);
	}

	private final void setLocationException(final LocationException locationException) {
		this.locationException = ObjectHelper.getDefault(locationException, LocationException.GENERAL);
	}

	public final String getuserMessage() {
		return userMessage;
	}

	public final LocationException getLocationExcetion() {
		return locationException;
	}
}
