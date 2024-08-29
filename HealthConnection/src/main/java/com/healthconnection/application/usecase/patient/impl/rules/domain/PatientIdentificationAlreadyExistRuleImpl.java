package com.healthconnection.application.usecase.patient.impl.rules.domain;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.exceptions.PatientIdentificationAlreadyExistException;
import com.healthconnection.domain.patient.rules.domain.PatientIdentificationDoesNotExistRule;

@Service
public class PatientIdentificationAlreadyExistRuleImpl implements PatientIdentificationDoesNotExistRule{
	
	private PatientRepository patientRepository;
	
	public PatientIdentificationAlreadyExistRuleImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public void execute(String identification) {

        var results = patientRepository.findByIdentification(identification);

        if (!results.isEmpty()) {
            throw new PatientIdentificationAlreadyExistException();
        }

    }
		

}
