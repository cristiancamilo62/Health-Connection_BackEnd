package com.healthconnection.application.primaryports.interactor.identificationtye.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.IdentificationTypeDTO;
import com.healthconnection.application.primaryports.interactor.identificationtye.ConsultIdentificationTypeInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.IdentificationTypeMapperDTO;
import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;
import com.healthconnection.application.usecase.identificationtype.ConsultIdentificationTypeUseCase;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;

@Service
public class ConsultIdentificationTypeInteractorImpl implements ConsultIdentificationTypeInteractor{
	
	private final ConsultIdentificationTypeUseCase consultIdentificationTypeUseCase;
	private final IdentificationTypeMapperDTO identificationTypeMapperDTO;
	

	public ConsultIdentificationTypeInteractorImpl(ConsultIdentificationTypeUseCase consultIdentificationTypeUseCase,
			IdentificationTypeMapperDTO identificationTypeMapperDTO) {
		super();
		this.consultIdentificationTypeUseCase = consultIdentificationTypeUseCase;
		this.identificationTypeMapperDTO = identificationTypeMapperDTO;
	}


	@Override
	public List<IdentificationTypeEntity> execute(IdentificationTypeDTO identificationTypeDTO) {
		
		IdentificationTypeDomain identificationTypeDomain = identificationTypeMapperDTO.toDomain(identificationTypeDTO);
		
		List<IdentificationTypeEntity> identifications = consultIdentificationTypeUseCase.execute(identificationTypeDomain);
		
		return identifications.stream().toList();
		
	}


}
