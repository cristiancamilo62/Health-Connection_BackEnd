package com.healthconnection.application.primaryports.interactor.healthprofessional.impl;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.HealthProfessionalDTO;
import com.healthconnection.application.primaryports.interactor.healthprofessional.RegisterHealthProfessionalInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.HealthProfessionalMapperDTO;
import com.healthconnection.application.usecase.healthprofessional.RegisterHealthProfessionalUseCase;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public class RegisterHealthProfessionalInteractorImpl implements RegisterHealthProfessionalInteractor{

	private final HealthProfessionalMapperDTO healthProfessionalMapperDTO;
	private final RegisterHealthProfessionalUseCase registerHealthProfessionalUseCase;
	
	
	public RegisterHealthProfessionalInteractorImpl(HealthProfessionalMapperDTO healthProfessionalMapperDTO,
			RegisterHealthProfessionalUseCase registerHealthProfessionalUseCase) {
		super();
		this.healthProfessionalMapperDTO = healthProfessionalMapperDTO;
		this.registerHealthProfessionalUseCase = registerHealthProfessionalUseCase;
	}

	@Override
	public void execute(HealthProfessionalDTO healthProfessionalDTO) {
		
		HealthProfessionalDomain healthProfessionalDomain = healthProfessionalMapperDTO.toDomain(healthProfessionalDTO);
		
		registerHealthProfessionalUseCase.execute(healthProfessionalDomain);
	}

}
