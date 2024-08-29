package com.healthconnection.application.primaryports.interactor.servicetype.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.ServiceTypeDTO;
import com.healthconnection.application.primaryports.interactor.servicetype.ConsultServiceTypeInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.ServiceTypeMapperDTO;
import com.healthconnection.application.secondaryports.entity.ServiceTypeEntity;
import com.healthconnection.application.usecase.servicetype.ConsultServiceTypeUseCase;
import com.healthconnection.domain.servicetype.ServiceTypeDomain;

@Service
public class ConsultServiceTypeInteractorImpl implements ConsultServiceTypeInteractor{

	private final ServiceTypeMapperDTO serviceTypeMapperDTO;
	private final ConsultServiceTypeUseCase consultServiceTypeUseCase;
	
	
	public ConsultServiceTypeInteractorImpl(ServiceTypeMapperDTO serviceTypeMapperDTO,
			ConsultServiceTypeUseCase consultServiceTypeUseCase) {
		super();
		this.serviceTypeMapperDTO = serviceTypeMapperDTO;
		this.consultServiceTypeUseCase = consultServiceTypeUseCase;
	}

	@Override
	public List<ServiceTypeEntity> execute(ServiceTypeDTO serviceTypeDTO) {
		
		ServiceTypeDomain serviceTypeDomain = serviceTypeMapperDTO.toDomain(serviceTypeDTO);
		
		List<ServiceTypeEntity> serviceTypeEntities = consultServiceTypeUseCase.execute(serviceTypeDomain);
		
		return serviceTypeEntities.stream().toList();
		
	}

}
