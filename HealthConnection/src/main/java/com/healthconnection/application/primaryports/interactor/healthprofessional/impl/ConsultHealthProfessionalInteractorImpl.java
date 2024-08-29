package com.healthconnection.application.primaryports.interactor.healthprofessional.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.HealthProfessionalDTO;
import com.healthconnection.application.primaryports.interactor.healthprofessional.ConsultHealthProfessionalInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.HealthProfessionalMapperDTO;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;
import com.healthconnection.application.usecase.healthprofessional.ConsultHealthprofessionalUseCase;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public class ConsultHealthProfessionalInteractorImpl implements ConsultHealthProfessionalInteractor{

	private final ConsultHealthprofessionalUseCase consultHealthprofessionalUseCase;
	private final HealthProfessionalMapperDTO healthProfessionalMapperDTO;
	
	
	public ConsultHealthProfessionalInteractorImpl(ConsultHealthprofessionalUseCase consultHealthprofessionalUseCase,
			HealthProfessionalMapperDTO healthProfessionalMapperDTO) {
		super();
		this.consultHealthprofessionalUseCase = consultHealthprofessionalUseCase;
		this.healthProfessionalMapperDTO = healthProfessionalMapperDTO;
	}


	@Override
	public List<HealthProfessionalEntity> execute(HealthProfessionalDTO healthProfessionalDTO) {
		
		HealthProfessionalDomain healthProfessionalDomain = healthProfessionalMapperDTO.toDomain(healthProfessionalDTO);
		
		List<HealthProfessionalEntity> healthProfessionalEntities = consultHealthprofessionalUseCase.execute(healthProfessionalDomain);
		
		return healthProfessionalEntities.stream().toList();
	}

}
