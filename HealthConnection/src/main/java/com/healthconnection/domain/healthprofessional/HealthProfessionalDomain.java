package com.healthconnection.domain.healthprofessional;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.IdentificationTypeDTO;
import com.healthconnection.application.primaryports.dto.ServiceTypeDTO;
import com.healthconnection.domain.role.RoleDomain;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class HealthProfessionalDomain {
	
	private UUID id;
	private String identification;
	private String firstName;
    private String middleName;
    private String lastName;
    private String middleLastName;
	private ServiceTypeDTO service;
	private IdentificationTypeDTO identificationType;
	private RoleDomain role;
	
	
	public HealthProfessionalDomain(UUID id, String identification, String firstName, String middleName,
			String lastName, String middleLastName, ServiceTypeDTO service, IdentificationTypeDTO identificationType) {
		setId(id);
		setIdentification(identification);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setMiddleLastName(middleLastName);
		setService(service);
		setIdentificationType(identificationType);
		setRole(role);
	}
	public final UUID getId() {
		return id;
	}
	public final void setId(UUID id) {
		this.id = id;
	}
	public final String getIdentification() {
		return identification;
	}
	public final void setIdentification(String identification) {
		this.identification = identification;
	}
	public final String getFirstName() {
		return firstName;
	}
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public final String getMiddleName() {
		return middleName;
	}
	public final void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public final String getLastName() {
		return lastName;
	}
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public final String getMiddleLastName() {
		return middleLastName;
	}
	public final void setMiddleLastName(String middleLastName) {
		this.middleLastName = middleLastName;
	}
	public final ServiceTypeDTO getService() {
		return service;
	}
	public final void setService(ServiceTypeDTO service) {
		this.service = service;
	}
	public final IdentificationTypeDTO getIdentificationType() {
		return identificationType;
	}
	public final void setIdentificationType(IdentificationTypeDTO identificationType) {
		this.identificationType = identificationType;
	}
	public final RoleDomain getRole() {
		return role;
	}
	public final void setRole(RoleDomain role) {
		this.role = role;
	}
}
