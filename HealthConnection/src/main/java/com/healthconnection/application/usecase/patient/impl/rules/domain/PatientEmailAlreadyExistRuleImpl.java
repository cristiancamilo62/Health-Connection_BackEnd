package com.healthconnection.application.usecase.patient.impl.rules.domain;


import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.exceptions.PatientEmailAlreadyExistException;
import com.healthconnection.domain.patient.rules.domain.PatientEmailDoesNotExistRule;

import org.springframework.stereotype.Service;

@Service
public class PatientEmailAlreadyExistRuleImpl implements PatientEmailDoesNotExistRule{

	private PatientRepository patientRepository;

	public PatientEmailAlreadyExistRuleImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
	

	@Override
    public void execute(String email) {
        
		var results = patientRepository.existsByEmail(email);
    	
        if (results) {
            throw new PatientEmailAlreadyExistException();
        }
    }


}

