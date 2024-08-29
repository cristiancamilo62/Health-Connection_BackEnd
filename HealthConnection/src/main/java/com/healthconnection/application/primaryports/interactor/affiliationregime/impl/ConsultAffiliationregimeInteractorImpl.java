package com.healthconnection.application.primaryports.interactor.affiliationregime.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.AffiliationRegimeDTO;
import com.healthconnection.application.primaryports.interactor.affiliationregime.ConsultAffiliationRegimeInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.AffiliationRegimeMapperDTO;
import com.healthconnection.application.secondaryports.entity.AffiliationRegimeEntity;
import com.healthconnection.application.usecase.affiliationregime.ConsultAffiliationRegimeUseCase;
import com.healthconnection.domain.affiliationregime.AffiliationRegimeDomain;

@Service
public class ConsultAffiliationregimeInteractorImpl implements ConsultAffiliationRegimeInteractor{
	
	private final AffiliationRegimeMapperDTO affiliationRegimeMapperDTO;
	private final ConsultAffiliationRegimeUseCase consultAffiliationRegimeUseCase;
	

	public ConsultAffiliationregimeInteractorImpl(AffiliationRegimeMapperDTO affiliationRegimeMapperDTO,
			ConsultAffiliationRegimeUseCase consultAffiliationRegimeUseCase) {
		super();
		this.affiliationRegimeMapperDTO = affiliationRegimeMapperDTO;
		this.consultAffiliationRegimeUseCase = consultAffiliationRegimeUseCase;
	}


	@Override
	public List<AffiliationRegimeEntity> execute(AffiliationRegimeDTO dto) {
		
		AffiliationRegimeDomain affiliationRegimeDomain = affiliationRegimeMapperDTO.toDomain(dto);
		
		List<AffiliationRegimeEntity> affiliationRegimeEntities = consultAffiliationRegimeUseCase.execute(affiliationRegimeDomain);
		
		return affiliationRegimeEntities.stream().toList();
	}

}
