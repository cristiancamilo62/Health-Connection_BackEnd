package com.healthconnection.application.primaryports.interactor.patient.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.patient.RegisterPatientInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.PatientMapperDTO;
import com.healthconnection.application.usecase.patient.RegisterPatientUseCase;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public class RegisterPatientInteractorImpl implements RegisterPatientInteractor{
	
	private PatientMapperDTO patientMapperDTO;
	private RegisterPatientUseCase registerPatientUseCase;

	
	
	public RegisterPatientInteractorImpl(PatientMapperDTO patientMapperDTO,
			RegisterPatientUseCase registerPatientUseCase) {
		this.patientMapperDTO = patientMapperDTO;
		this.registerPatientUseCase = registerPatientUseCase;
	}

	@Override
	public void execute(PatientDTO clientDTO) {
		
		PatientDomain patientDomain = patientMapperDTO.toDomain(clientDTO);
		
		registerPatientUseCase.execute(patientDomain);
		
		
	}

	
	

}
