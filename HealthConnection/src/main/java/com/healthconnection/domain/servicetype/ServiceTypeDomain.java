package com.healthconnection.domain.servicetype;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ServiceTypeDomain {
	
	private UUID id;
	
	private String name;

	public ServiceTypeDomain(UUID id, String name) {
		setId(id);
		setName(name);
	}

	public final UUID getId() {
		return id;
	}

	public final void setId(UUID id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
	
	
	

}
