package com.healthconnection.application.usecase.healthprofessional.impl.rules.domain;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.repository.concrete.healthprofessional.HealthProfessionalRepository;
import com.healthconnection.application.usecase.healthprofessional.exceptions.HealthProfesionalIdAlreadyExistException;
import com.healthconnection.domain.healthprofessional.rules.domain.HealthProfessionalIdDoesNotExistRule;

@Service
public class HealthProfessionalIdAlreadyExistRuleImpl implements HealthProfessionalIdDoesNotExistRule{

	private HealthProfessionalRepository healthProfesionalRepository;
	
	public HealthProfessionalIdAlreadyExistRuleImpl(HealthProfessionalRepository healthProfesionalRepository) {
		super();
		this.healthProfesionalRepository = healthProfesionalRepository;
	}

	@Override
	public void execute(UUID id) {
		
		var results = healthProfesionalRepository.findById(id);
		
		if(!results.isEmpty()) {
			throw new HealthProfesionalIdAlreadyExistException();
		}
	}

}
