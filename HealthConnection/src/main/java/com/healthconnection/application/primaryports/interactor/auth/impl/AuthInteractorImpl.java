package com.healthconnection.application.primaryports.interactor.auth.impl;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.auth.AuthInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.PatientMapperDTO;
import com.healthconnection.application.usecase.auth.AuthUseCase;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public class AuthInteractorImpl implements AuthInteractor{

	private PatientMapperDTO patientMapperDTO;
	private AuthUseCase authUseCase;
	
	
	public AuthInteractorImpl(PatientMapperDTO patientMapperDTO, AuthUseCase authUseCase) {
		super();
		this.patientMapperDTO = patientMapperDTO;
		this.authUseCase = authUseCase;
	}

	@Override
	public boolean execute(PatientDTO patient) {
		
		PatientDomain patientDomain = patientMapperDTO.toDomain(patient);
		
		return authUseCase.execute(patientDomain);
		
		
		
	}
	
	

}
