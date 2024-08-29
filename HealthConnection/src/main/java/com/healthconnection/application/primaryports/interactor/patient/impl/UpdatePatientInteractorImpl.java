package com.healthconnection.application.primaryports.interactor.patient.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.patient.UpdatePatientInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.PatientMapperDTO;
import com.healthconnection.application.usecase.patient.UpdatePatientUseCase;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public class UpdatePatientInteractorImpl implements  UpdatePatientInteractor{
	
	private final PatientMapperDTO patientMapperDTO;
	private final UpdatePatientUseCase updatePatientUseCase ;

	public UpdatePatientInteractorImpl(PatientMapperDTO patientMapperDTO,
			UpdatePatientUseCase updatePatientUseCase) {
		super();
		this.patientMapperDTO = patientMapperDTO;
		this.updatePatientUseCase = updatePatientUseCase;
	}



	@Override
	public void execute(PatientDTO patientDTO) {
		
		PatientDomain patientDomainUpdate = patientMapperDTO.toDomain(patientDTO);
		
		updatePatientUseCase.execute(patientDomainUpdate);
		
		
	}

}
