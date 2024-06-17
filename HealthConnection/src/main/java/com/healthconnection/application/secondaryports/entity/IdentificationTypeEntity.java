package com.healthconnection.application.secondaryports.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IdentificationType")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationTypeEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
}
