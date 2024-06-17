package com.healthconnection.domain.appointment;

import java.sql.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.domain.appointmentservicedata.AppointmentServiceDataDomain;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class AppointmentDomain {
	
	private UUID id;
	private HealthProfessionalDomain healthProfessional;
	private Date startDate;
	private Date endDate;
	private AppointmentServiceDataDomain appointmentServiceData;
	private boolean estadoCita;
	
	
	public AppointmentDomain(UUID id, HealthProfessionalDomain healthProfessional,
			Date startDate, Date endDate, AppointmentServiceDataDomain appointmentServiceData,
			boolean estadoCita) {
		setId(id);
		setHealthProfessional(healthProfessional);
		setStartDate(startDate);
		setEndDate(endDate);
		setAppointmentServiceData(appointmentServiceData);
		setEstadoCita(estadoCita);
	}


	public final UUID getId() {
		return id;
	}


	public final void setId(UUID id) {
		this.id = id;
	}


	public final HealthProfessionalDomain getHealthProfessional() {
		return healthProfessional;
	}


	public final void setHealthProfessional(HealthProfessionalDomain healthProfessional) {
		this.healthProfessional = healthProfessional;
	}

	public final Date getStartDate() {
		return startDate;
	}


	public final void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public final Date getEndDate() {
		return endDate;
	}


	public final void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public final AppointmentServiceDataDomain getAppointmentServiceData() {
		return appointmentServiceData;
	}


	public final void setAppointmentServiceData(AppointmentServiceDataDomain appointmentServiceData) {
		this.appointmentServiceData = appointmentServiceData;
	}


	public final boolean isEstadoCita() {
		return estadoCita;
	}


	public final void setEstadoCita(boolean estadoCita) {
		this.estadoCita = estadoCita;
	}
	
	
	
	

}
