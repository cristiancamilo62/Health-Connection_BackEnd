package com.healthconnection.application.secondaryports.entity;

import java.time.LocalDateTime;
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
@Table(name = "Appointment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentEntity {

	@Id
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "healthProfessional")
	private HealthProfessionalEntity healthProfessional;

	@Column(name = "startDate")
	private LocalDateTime startDate;

	@Column(name = "endDate")
	private LocalDateTime endDate;

	@ManyToOne
	@JoinColumn(name = "appointmentServiceData")
	private AppointmentServiceDataEntity appointmentServiceData;

	@Column(name = "estadoCita")
	private boolean estadoCita;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
}
