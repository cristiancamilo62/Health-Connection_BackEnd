package com.healthconnection.application.usecase.healthprofessional.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.HealthProfessionalMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.healthprofessional.HealthProfessionalRepository;
import com.healthconnection.application.usecase.healthprofessional.ConsultHealthprofessionalUseCase;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public class ConsultHealthProfessionalUseCaseImpl implements ConsultHealthprofessionalUseCase{

	private final HealthProfessionalRepository healthProfessionalRepository;
	private final HealthProfessionalMapperEntity healthProfessionalMapperEntity;
	
	public ConsultHealthProfessionalUseCaseImpl(HealthProfessionalRepository healthProfessionalRepository,
			HealthProfessionalMapperEntity healthProfessionalMapperEntity) {
		super();
		this.healthProfessionalRepository = healthProfessionalRepository;
		this.healthProfessionalMapperEntity = healthProfessionalMapperEntity;
	}

	@Override
	public List<HealthProfessionalEntity> execute(HealthProfessionalDomain healthProfessionalDomain) {
		
	    var healthProfessionalEntity = healthProfessionalMapperEntity.toEntity(healthProfessionalDomain);
	    if(UuidHelper.isDefault(healthProfessionalEntity.getId()) || ObjectHelper.isEmpty(healthProfessionalEntity.getId())){
	    	healthProfessionalEntity.setId(null);
	    }

	    if (UuidHelper.isUuidEmpty(healthProfessionalEntity.getIdentificationType().getId()) ||
	    		(healthProfessionalEntity.getIdentificationType() != null || 
	        (UuidHelper.isDefault(healthProfessionalEntity.getIdentificationType().getId()) ))) {
	        healthProfessionalEntity.setIdentificationType(null);
	    }
	    if (UuidHelper.isUuidEmpty(healthProfessionalEntity.getServiceType().getId()) ||
	    		(healthProfessionalEntity.getServiceType() != null || 
	        (UuidHelper.isDefault(healthProfessionalEntity.getServiceType().getId())))) {
	        healthProfessionalEntity.setServiceType(null);
	    }
	    if ( UuidHelper.isUuidEmpty(healthProfessionalEntity.getRole().getId()) ||
	    		(healthProfessionalEntity.getRole() != null || 
	        (UuidHelper.isDefault(healthProfessionalEntity.getRole().getId()) ))) {
	        healthProfessionalEntity.setRole(null);
	    }

	    ExampleMatcher matcher = ExampleMatcher.matching()
	            .withIgnoreNullValues()
	            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

	    Example<HealthProfessionalEntity> example = Example.of(healthProfessionalEntity, matcher);

	    List<HealthProfessionalEntity> results = healthProfessionalRepository.findAll(example);


	    return results;
	}
}
