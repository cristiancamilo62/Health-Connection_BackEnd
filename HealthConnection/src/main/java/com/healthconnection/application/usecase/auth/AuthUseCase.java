package com.healthconnection.application.usecase.auth;

import org.springframework.stereotype.Service;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public interface AuthUseCase {
	
	boolean execute(PatientDomain patientDomain);

}
