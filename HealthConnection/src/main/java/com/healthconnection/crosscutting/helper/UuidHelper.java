package com.healthconnection.crosscutting.helper;

import java.util.UUID;

public class UuidHelper {
	
	public static final String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
    public static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_AS_STRING);

    private UuidHelper() {
        super();
    }

    public static final UUID generarNuevoUuid() {
        return UUID.randomUUID();
    }

    public static final UUID obtenerDefectoUUID(final UUID uuidValue) {
        return (esUuidNulo(uuidValue)) ? DEFAULT_UUID : uuidValue;
    }

   
    public static final boolean valorDefectoONulo(final UUID uuidValue) {
        return (esUuidNulo(uuidValue) || uuidValue.equals(DEFAULT_UUID));
    }
    
    public static final boolean valorDefecto(final UUID uuidValue) {
        return (!esUuidNulo(uuidValue) && uuidValue.equals(DEFAULT_UUID));
    }

    public static final boolean esUuidNulo(final UUID uuidValue) {
        return ObjectHelper.isNull(uuidValue);
    }

}
