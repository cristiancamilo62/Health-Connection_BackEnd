package com.healthconnection.application.primaryports.dto;

import java.sql.Date;
import java.util.UUID;
import com.healthconnection.crosscutting.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@AllArgsConstructor
public final class AppointmentDTO {
	
	private UUID id;
	private HealthProfessionalDTO healthProfessional;
	private Date startDate;
	private Date endDate;
	private AppointmentServiceDataDTO appointmentServiceData;
	private boolean estadoCita;
	
	
	public AppointmentDTO() {
		setId(UuidHelper.DEFAULT_UUID);
		setHealthProfessional(new HealthProfessionalDTO());
		setStartDate(new Date(0));
		setEndDate(new Date(0));
		setAppointmentServiceData(new AppointmentServiceDataDTO());
		setEstadoCita(false);
	}

}
