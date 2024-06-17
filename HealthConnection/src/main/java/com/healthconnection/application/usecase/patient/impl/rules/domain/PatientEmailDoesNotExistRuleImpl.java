package com.healthconnection.application.usecase.patient.impl.rules.domain;


import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.exceptions.PatientEmailDoesNotExistException;
import com.healthconnection.domain.patient.rules.PatientEmailDoesNotExistRule;
import org.springframework.stereotype.Service;

@Service
public class PatientEmailDoesNotExistRuleImpl implements PatientEmailDoesNotExistRule{

	private PatientRepository patientRepository;

	public PatientEmailDoesNotExistRuleImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
	

	@Override
    public void execute(String email) {
        
		var results = patientRepository.existsByEmail(email);
    	
        if (results) {
            throw new PatientEmailDoesNotExistException();
        }
    }


}

