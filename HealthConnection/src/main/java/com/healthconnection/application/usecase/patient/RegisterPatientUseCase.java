package com.healthconnection.application.usecase.patient;


import org.springframework.stereotype.Service;

import com.healthconnection.domain.patient.PatientDomain;

import jakarta.validation.Valid;

@Service
public interface RegisterPatientUseCase {
	
	void execute(PatientDomain patientDomain);

}
