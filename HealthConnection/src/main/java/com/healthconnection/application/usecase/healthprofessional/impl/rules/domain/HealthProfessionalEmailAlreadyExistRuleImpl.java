package com.healthconnection.application.usecase.healthprofessional.impl.rules.domain;

import com.healthconnection.application.secondaryports.repository.concrete.healthprofessional.HealthProfessionalRepository;
import com.healthconnection.application.usecase.healthprofessional.exceptions.HealthProfessionalEmailAlreadyExistException;
import com.healthconnection.domain.healthprofessional.rules.domain.HealthProfessionalEmailDoesNotExistRule;

import org.springframework.stereotype.Service;

@Service
public class HealthProfessionalEmailAlreadyExistRuleImpl implements HealthProfessionalEmailDoesNotExistRule{

	private HealthProfessionalRepository healthProfesionalRepository;

	public HealthProfessionalEmailAlreadyExistRuleImpl(HealthProfessionalRepository healthProfesionalRepository) {
		super();
		this.healthProfesionalRepository = healthProfesionalRepository;
	}
	

	@Override
    public void execute(String email) {
        
		var results = healthProfesionalRepository.existsByEmail(email);
    	
        if (results) {
            throw new HealthProfessionalEmailAlreadyExistException();
        }
    }


}

