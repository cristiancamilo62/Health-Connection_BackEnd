package com.healthconnection.crosscutting.helper;

import org.springframework.stereotype.Component;


@Component
public final class ObjectHelper {
	
    public static final String EMPTY = "";

	private ObjectHelper() {
		super();
	}

	public static final <T> boolean isNull(final T object) {
		return object == null;
	}

	public static final <T> T getDefault(final T object, final T defaultObject) {
		return isNull(object) ? defaultObject : object;
	}
	
	public static final <T> boolean isEmpty(final T object) {
		return object.equals(EMPTY);
	}
	
	
}
