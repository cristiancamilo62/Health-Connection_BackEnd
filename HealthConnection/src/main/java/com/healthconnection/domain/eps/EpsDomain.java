package com.healthconnection.domain.eps;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;

@Service
public class EpsDomain {
	
	private UUID id;

	private String name;

	public EpsDomain() {
		setId(UuidHelper.DEFAULT_UUID);
		setName(TextHelper.EMPTY);
		
	}
	
	public EpsDomain(final UUID id, final String name) {
		setId(id);
		setName(name);
		
	}
	
	public static final EpsDomain crear(final UUID id, final String name) {
		return new EpsDomain(id, name);
	}
	
	public static final EpsDomain crear() {
		return new EpsDomain();
	}

	public final UUID getId() {
		return id;
	}

	public final String getName() {
		return name;
	}

	public final void setId(UUID id) {
		this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
	}

	public final void setName(String name) {
		this.name = ObjectHelper.getDefault(name, TextHelper.EMPTY);
	}
	
	
	
	

}
