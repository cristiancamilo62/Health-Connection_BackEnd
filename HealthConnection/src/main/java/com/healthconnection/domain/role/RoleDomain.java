package com.healthconnection.domain.role;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;

@Service
public class RoleDomain {
	
	private UUID id;
	
	private String name;
	

	public RoleDomain() {
		setId(UuidHelper.DEFAULT_UUID);
		setName(TextHelper.EMPTY);
	}

	public RoleDomain(UUID id, String name) {
		setId(id);
		setName(name);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

}
