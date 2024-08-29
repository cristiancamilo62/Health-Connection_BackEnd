package com.healthconnection.application.primaryports.interactor.eps.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.EpsDTO;
import com.healthconnection.application.primaryports.interactor.eps.ConsultEpsInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.EpsMapperDTO;
import com.healthconnection.application.secondaryports.entity.EpsEntity;
import com.healthconnection.application.usecase.eps.ConsultEpsUseCase;
import com.healthconnection.domain.eps.EpsDomain;

@Service
public class ConsultEpsInteractorImpl implements ConsultEpsInteractor{
	
	private final EpsMapperDTO epsMapperDTO;
	private final ConsultEpsUseCase epsUseCase;

	public ConsultEpsInteractorImpl(EpsMapperDTO epsMapperDTO, ConsultEpsUseCase epsUseCase) {
		super();
		this.epsMapperDTO = epsMapperDTO;
		this.epsUseCase = epsUseCase;
	}

	@Override
	public List<EpsEntity> execute(EpsDTO dto) {
		
		EpsDomain epsDomain = epsMapperDTO.toDomain(dto);
		
		List<EpsEntity> epsEntities = epsUseCase.execute(epsDomain);
		
		return epsEntities.stream().toList();
		
	}

}
