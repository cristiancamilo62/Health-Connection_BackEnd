package com.healthconnection.application.primaryports.interactor.affiliationregime;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.AffiliationRegimeDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;
import com.healthconnection.application.secondaryports.entity.AffiliationRegimeEntity;

@Service
public interface ConsultAffiliationRegimeInteractor extends InteractorWithReturn<AffiliationRegimeDTO, List<AffiliationRegimeEntity>>{

}
