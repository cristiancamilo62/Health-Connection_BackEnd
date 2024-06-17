package com.healthconnection.domain.identificationtype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;;

@Service
public class IdentificationTypeDomain {
	
	private UUID id;

	private String code;

	private String name;
	
	public IdentificationTypeDomain() {
        setId(UuidHelper.DEFAULT_UUID);
        setCode(TextHelper.EMPTY);
        setName(TextHelper.EMPTY);
        
	}
	
	public IdentificationTypeDomain(final UUID id, final String code, final String name) {
    	setId(id);
    	setCode(code);
    	setName(name);
	}

    public static final IdentificationTypeDomain crear(final UUID id, final String code, final String name) {
    	return new IdentificationTypeDomain(id, code, name);
    }

	public static final IdentificationTypeDomain crear() {
        return new IdentificationTypeDomain();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public final String getCode() {
		return code;
    }
    
    public void setId(UUID id) {
        this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
    }
	
    public final void setCode(String code) {
		this.code = ObjectHelper.getDefault(code, TextHelper.EMPTY);
	}
    
    public void setName(final String name) {
        this.name = ObjectHelper.getDefault(name, TextHelper.EMPTY);
    }

}
