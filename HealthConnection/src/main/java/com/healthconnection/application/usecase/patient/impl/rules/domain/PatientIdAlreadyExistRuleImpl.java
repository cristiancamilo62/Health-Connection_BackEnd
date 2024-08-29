package com.healthconnection.application.usecase.patient.impl.rules.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.exceptions.PatientIdAlreadyExistException;
import com.healthconnection.domain.patient.rules.domain.PatientIdDoesNotExistRule;

@Service
public class PatientIdAlreadyExistRuleImpl implements PatientIdDoesNotExistRule{

	private PatientRepository patientRepository;
	
	public PatientIdAlreadyExistRuleImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public void execute(UUID id) {
		
		var results = patientRepository.findById(id);
		
		if(!results.isEmpty()) {
			throw new PatientIdAlreadyExistException();
		}
	}

}
