package com.healthconnection.application.usecase.servicetype.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.ServiceTypeEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.ServiceTypeMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.servicetype.ServiceTypeRepository;
import com.healthconnection.application.usecase.servicetype.ConsultServiceTypeUseCase;
import com.healthconnection.domain.servicetype.ServiceTypeDomain;

@Service
public class ConsultServiceTypeUseCaseImpl implements ConsultServiceTypeUseCase{

	private final ServiceTypeRepository serviceTypeRepository;
	private final ServiceTypeMapperEntity serviceTypeMapperEntity;
	
	
	public ConsultServiceTypeUseCaseImpl(ServiceTypeRepository serviceTypeRepository,
			ServiceTypeMapperEntity serviceTypeMapperEntity) {
		super();
		this.serviceTypeRepository = serviceTypeRepository;
		this.serviceTypeMapperEntity = serviceTypeMapperEntity;
	}

	@Override
	public List<ServiceTypeEntity> execute(ServiceTypeDomain domain) {
		
		ServiceTypeEntity serviceTypeEntity = serviceTypeMapperEntity.toEntity(domain);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<ServiceTypeEntity> example = Example.of(serviceTypeEntity, matcher);
		
		return serviceTypeRepository.findAll(example);
		
	}

}
