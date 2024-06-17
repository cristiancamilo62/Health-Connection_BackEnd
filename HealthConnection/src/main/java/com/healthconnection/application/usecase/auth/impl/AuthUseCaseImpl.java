package com.healthconnection.application.usecase.auth.impl;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.PatientMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.auth.AuthUseCase;
import com.healthconnection.application.usecase.auth.exceptions.PatientNotRegisterException;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public class AuthUseCaseImpl implements AuthUseCase{

	private PatientRepository patientRepository;
	private PatientMapperEntity patientMapperEntity;
	
	public AuthUseCaseImpl(PatientRepository patientRepository, PatientMapperEntity patientMapperEntity) {
		super();
		this.patientRepository = patientRepository;
		this.patientMapperEntity = patientMapperEntity;
	}

	@Override
	public boolean execute(PatientDomain patientDomain) {
	
		PatientEntity patientEntity = patientMapperEntity.toEntity(patientDomain);
		
		var results = patientRepository.existsByEmailAndPassword(patientEntity.getEmail(),
				patientEntity.getPassword());
		
		if(!results) {
			throw new PatientNotRegisterException();
		}
		
		return results;
		
	}

}
