package com.healthconnection.application.primaryports.dto;

import java.util.UUID;

import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@AllArgsConstructor
public class ServiceTypeDTO {
	
	private UUID id;
	
	private String name;

	public ServiceTypeDTO() {
		setId(UuidHelper.DEFAULT_UUID);
		setName(TextHelper.EMPTY);
	}
	
	
	
}
