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
@Table(name = "AppointmentServiceData")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentServiceDataEntity {
	
	@Id
	@Column(name = "id")
	private UUID code;
	
	@Column(name = "clinic")
	private String clinic;
	
	@Column(name = "price")
	private long price;
	
	
}