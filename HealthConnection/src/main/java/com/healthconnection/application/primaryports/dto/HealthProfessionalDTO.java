package com.healthconnection.application.primaryports.dto;

import java.util.UUID;
import org.springframework.stereotype.Component;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@AllArgsConstructor
public class HealthProfessionalDTO {

	private UUID id;
	private String identification;
	private String firstName;
    private String middleName;
    private String lastName;
    private String middleLastName;
	private ServiceTypeDTO service;
	private IdentificationTypeDTO identificationType;
	private RoleDTO role;
	
	public HealthProfessionalDTO() {
		setId(UuidHelper.DEFAULT_UUID);
		setIdentification(TextHelper.EMPTY);
		setFirstName(TextHelper.EMPTY);
		setMiddleName(TextHelper.EMPTY);
		setLastName(TextHelper.EMPTY);
		setMiddleLastName(TextHelper.EMPTY);
		setService(new ServiceTypeDTO());
		setIdentificationType(new IdentificationTypeDTO());
		setRole(new RoleDTO());
	}
	
	
	
	
	

	
	
}
