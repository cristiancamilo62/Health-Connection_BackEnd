package com.healthconnection.application.usecase.healthprofessional.impl.rules.domain;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.repository.concrete.healthprofessional.HealthProfessionalRepository;
import com.healthconnection.application.usecase.healthprofessional.exceptions.HealthProfessionalIdentificationAlreadyExistException;
import com.healthconnection.domain.healthprofessional.rules.domain.HealthProfessionalIdentificationDoesNotExistRule;

@Service
public class HealthProfessionalIdentificationAlreadyExistRuleImpl implements HealthProfessionalIdentificationDoesNotExistRule{
	
	private HealthProfessionalRepository healthProfesionalRepository;
	
	public HealthProfessionalIdentificationAlreadyExistRuleImpl(HealthProfessionalRepository healthProfesionalRepository) {
		super();
		this.healthProfesionalRepository = healthProfesionalRepository;
	}

	@Override
	public void execute(String identification) {

        var results = healthProfesionalRepository.findByIdentification(identification);

        if (!results.isEmpty()) {
            throw new HealthProfessionalIdentificationAlreadyExistException();
        }

    }
		

}
