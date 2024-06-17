package com.healthconnection.application.usecase.patient.impl.rules.domain;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.exceptions.PatientIdentificationDoesNotExistException;
import com.healthconnection.domain.patient.rules.PatientIdentificationDoesNotExistRule;

@Service
public class PatientIdentificationDoesNotExistRuleImpl implements PatientIdentificationDoesNotExistRule{
	
	private PatientRepository patientRepository;
	
	public PatientIdentificationDoesNotExistRuleImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public void execute(String identification) {

        var results = patientRepository.findByIdentification(identification);

        if (!results.isEmpty()) {
            throw new PatientIdentificationDoesNotExistException();
        }

    }
		

}
