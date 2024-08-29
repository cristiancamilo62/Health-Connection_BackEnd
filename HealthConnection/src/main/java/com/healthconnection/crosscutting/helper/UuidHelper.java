package com.healthconnection.crosscutting.helper;

import java.util.UUID;

public class UuidHelper {
	
	public static final String DEFAULT_UUID_AS_STRING = "00000000-0000-0000-0000-000000000000";
    public static final UUID DEFAULT_UUID = UUID.fromString(DEFAULT_UUID_AS_STRING);

    private UuidHelper() {
        super();
    }

    public static final UUID generateNewUuid() {
        return UUID.randomUUID();
    }

    public static final UUID getDefaultUuid(final UUID uuidValue) {
        return (isUuidNull(uuidValue)) ? DEFAULT_UUID : uuidValue;
    }

    public static final boolean isDefaultOrNull(final UUID uuidValue) {
        return (isUuidNull(uuidValue) || uuidValue.equals(DEFAULT_UUID));
    }
    
    public static final boolean isDefault(final UUID uuidValue) {
        return (!isUuidNull(uuidValue) && uuidValue.equals(DEFAULT_UUID));
    }

    public static final boolean isUuidNull(final UUID uuidValue) {
        return ObjectHelper.isNull(uuidValue);
    }
    
    public static final boolean isUuidEmpty(final UUID uuidValue) {
    	return ObjectHelper.isEmpty(uuidValue);
    }
}

