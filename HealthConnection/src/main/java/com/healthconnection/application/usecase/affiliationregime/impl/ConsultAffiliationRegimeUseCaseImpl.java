package com.healthconnection.application.usecase.affiliationregime.impl;

import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.AffiliationRegimeEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.AffiliationRegimeMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.affiliationregime.AffiliationRegimeRepository;
import com.healthconnection.application.usecase.affiliationregime.ConsultAffiliationRegimeUseCase;
import com.healthconnection.domain.affiliationregime.AffiliationRegimeDomain;

@Service
public class ConsultAffiliationRegimeUseCaseImpl implements ConsultAffiliationRegimeUseCase{

	private final AffiliationRegimeMapperEntity affiliationRegimeMapperEntity;
	private final AffiliationRegimeRepository affiliationRegimeRepository;
	
	
	public ConsultAffiliationRegimeUseCaseImpl(AffiliationRegimeMapperEntity affiliationRegimeMapperEntity,
			AffiliationRegimeRepository affiliationRegimeRepository) {
		super();
		this.affiliationRegimeMapperEntity = affiliationRegimeMapperEntity;
		this.affiliationRegimeRepository = affiliationRegimeRepository;
	}



	@Override
	public List<AffiliationRegimeEntity> execute(AffiliationRegimeDomain affiliationRegimeDomain) {
	
		AffiliationRegimeEntity affiliationRegimeEntity = affiliationRegimeMapperEntity.toEntity(affiliationRegimeDomain);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<AffiliationRegimeEntity> example = Example.of(affiliationRegimeEntity,matcher);
		
		return affiliationRegimeRepository.findAll(example);		
	}

}
