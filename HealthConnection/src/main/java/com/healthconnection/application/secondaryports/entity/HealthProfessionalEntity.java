package com.healthconnection.application.secondaryports.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HealthProfessional")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HealthProfessionalEntity {

	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "identification")
	private String identification;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "middleLastName")
	private String middleLastName;
	
	@ManyToOne
	@JoinColumn(name = "service")
	private ServiceTypeEntity service;
	
	@ManyToOne
	@JoinColumn(name = "identificationType")
	private IdentificationTypeEntity identificationType;
	
	@ManyToOne
    @JoinColumn(name = "role")
    private RoleEntity role;
	
}
