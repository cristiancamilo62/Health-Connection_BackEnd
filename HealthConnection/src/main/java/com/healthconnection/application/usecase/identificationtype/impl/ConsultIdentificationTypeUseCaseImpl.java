package com.healthconnection.application.usecase.identificationtype.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.IdentificationTypeMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.identificationtype.IdentificationTypeRepository;
import com.healthconnection.application.usecase.identificationtype.ConsultIdentificationTypeUseCase;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;

@Service
public class ConsultIdentificationTypeUseCaseImpl implements ConsultIdentificationTypeUseCase{
	
	private final IdentificationTypeRepository identificationTypeRepository;
	private final IdentificationTypeMapperEntity identificationTypeMapperEntity;

	
	public ConsultIdentificationTypeUseCaseImpl(IdentificationTypeRepository identificationTypeRepository,
			IdentificationTypeMapperEntity identificationTypeMapperEntity) {
		super();
		this.identificationTypeRepository = identificationTypeRepository;
		this.identificationTypeMapperEntity = identificationTypeMapperEntity;
	}

	@Override
	public final List<IdentificationTypeEntity> execute(IdentificationTypeDomain identificationTypeDomain) {
		
		var identificationTypeEntity = identificationTypeMapperEntity.toEntity(identificationTypeDomain);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnorePaths("id")
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<IdentificationTypeEntity> example = Example.of(identificationTypeEntity,matcher);
		
		return identificationTypeRepository.findAll(example);
	}

}
