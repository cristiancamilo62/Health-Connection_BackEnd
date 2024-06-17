package com.healthconnection.crosscutting.helper;

public class LongHelper {
	
	private LongHelper() {
		super();
	}
	public static final Long DEFAULT_LONG = 0L;
	
	public static final boolean esNulo( final Long valor) {
		return ObjectHelper.isNull(valor);
	}
	
	public static final boolean esValorPorDefecto(final Long valor) {
	    return !esNulo(valor) && valor.equals(DEFAULT_LONG);
	}

}
