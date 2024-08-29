package com.healthconnection.application.primaryports.dto;

import java.time.LocalDateTime;
import java.util.UUID;
import com.healthconnection.crosscutting.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public final class AppointmentDTO {
    
    private UUID id;
    private HealthProfessionalDTO healthProfessional;
    private LocalDateTime startDate;
    private LocalDateTime endDate; 
    private AppointmentServiceDataDTO appointmentServiceData;
    private boolean estadoCita;
    private PatientDTO patientDTO;
    
    public AppointmentDTO() {
        setId(UuidHelper.DEFAULT_UUID);
        setHealthProfessional(new HealthProfessionalDTO());
        setStartDate(LocalDateTime.now()); 
        setEndDate(LocalDateTime.now().plusHours(1)); 
        setAppointmentServiceData(new AppointmentServiceDataDTO());
        setEstadoCita(false);
        setPatientDTO(new PatientDTO());
    }

}
