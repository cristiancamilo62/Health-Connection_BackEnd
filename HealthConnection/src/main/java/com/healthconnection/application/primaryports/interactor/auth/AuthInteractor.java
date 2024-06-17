package com.healthconnection.application.primaryports.interactor.auth;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.PatientDTO;

@Service
public interface AuthInteractor {
	
	boolean execute(PatientDTO patient);

}
