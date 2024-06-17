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
@Table(name = "AffiliationRegime")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public final class AffiliationRegimeEntity {
	
	@Id
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "serviceCoverages")
	private String serviceCoverages;
	
}
