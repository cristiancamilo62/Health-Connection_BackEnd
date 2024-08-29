package com.healthconnection.domain.appointment;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.domain.appointmentservicedata.AppointmentServiceDataDomain;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;
import com.healthconnection.domain.patient.PatientDomain;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class AppointmentDomain {
    
    private UUID id;
    private HealthProfessionalDomain healthProfessional;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private AppointmentServiceDataDomain appointmentServiceData;
    private boolean estadoCita;
    private PatientDomain patientDomain;

	public AppointmentDomain(UUID id, HealthProfessionalDomain healthProfessional, LocalDateTime startDate,
			LocalDateTime endDate, AppointmentServiceDataDomain appointmentServiceData, boolean estadoCita,
			PatientDomain patientDomain) {
		super();
		this.id = id;
		this.healthProfessional = healthProfessional;
		this.startDate = startDate;
		this.endDate = endDate;
		this.appointmentServiceData = appointmentServiceData;
		this.estadoCita = estadoCita;
		this.patientDomain = patientDomain;
	}
    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public HealthProfessionalDomain getHealthProfessional() {
        return healthProfessional;
    }

    public void setHealthProfessional(HealthProfessionalDomain healthProfessional) {
        this.healthProfessional = healthProfessional;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public AppointmentServiceDataDomain getAppointmentServiceData() {
        return appointmentServiceData;
    }

    public void setAppointmentServiceData(AppointmentServiceDataDomain appointmentServiceData) {
        this.appointmentServiceData = appointmentServiceData;
    }

    public boolean isEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(boolean estadoCita) {
        this.estadoCita = estadoCita;
    }


	public final PatientDomain getPatientDomain() {
		return patientDomain;
	}


	public final void setPatientDomain(PatientDomain patientDomain) {
		this.patientDomain = patientDomain;
	}



}
