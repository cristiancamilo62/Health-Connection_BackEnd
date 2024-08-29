package com.healthconnection.application.usecase.eps.impl;

import java.util.List;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.EpsEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.EpsMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.eps.EpsRepository;
import com.healthconnection.application.usecase.eps.ConsultEpsUseCase;
import com.healthconnection.domain.eps.EpsDomain;


@Service
public class ConsultEpsUseCaseImpl implements ConsultEpsUseCase{

	private final EpsRepository epsRepository;
	private final EpsMapperEntity epsMapperEntity;
	
	
	public ConsultEpsUseCaseImpl(EpsRepository epsRepository, EpsMapperEntity epsMapperEntity) {
		super();
		this.epsRepository = epsRepository;
		this.epsMapperEntity = epsMapperEntity;
	}

	@Override
	public List<EpsEntity> execute(EpsDomain domain) {
		
		EpsEntity epsEntity = epsMapperEntity.toEntity(domain);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnorePaths("id")
				.withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		
		Example<EpsEntity> example = Example.of(epsEntity,matcher);
		
		return epsRepository.findAll(example);
		
	}

}
