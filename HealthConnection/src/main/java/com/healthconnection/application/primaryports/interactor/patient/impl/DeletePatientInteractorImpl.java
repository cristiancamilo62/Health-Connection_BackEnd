package com.healthconnection.application.primaryports.interactor.patient.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.patient.DeletePatientInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.PatientMapperDTO;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.usecase.patient.ConsultPatientUseCase;
import com.healthconnection.application.usecase.patient.DeletePatientUseCase;
import com.healthconnection.application.usecase.patient.exceptions.PatientDoesNotExistException;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public class DeletePatientInteractorImpl implements DeletePatientInteractor{

	private final PatientMapperDTO patientMapperDTO;
	private final DeletePatientUseCase deletePatientUseCase;
	private final ConsultPatientUseCase consultPatientUseCase;

	public DeletePatientInteractorImpl(PatientMapperDTO patientMapperDTO, DeletePatientUseCase deletePatientUseCase,
			ConsultPatientUseCase consultPatientUseCase) {
		super();
		this.patientMapperDTO = patientMapperDTO;
		this.deletePatientUseCase = deletePatientUseCase;
		this.consultPatientUseCase = consultPatientUseCase;
	}

	@Override
	public void execute(PatientDTO patientDTO) {
		
		PatientDomain patientDomainDelete = patientMapperDTO.toDomain(patientDTO);
		
		List<PatientEntity> result = consultPatientUseCase.execute(patientDomainDelete) ;
		
		if(result.isEmpty()) {
			throw new PatientDoesNotExistException();
		}
		
		deletePatientUseCase.execute(patientDomainDelete);
		
	}

}
