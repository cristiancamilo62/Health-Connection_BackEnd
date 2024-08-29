package com.healthconnection.application.usecase.affiliationregime;

import java.util.List;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.AffiliationRegimeEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;
import com.healthconnection.domain.affiliationregime.AffiliationRegimeDomain;

@Service
public interface ConsultAffiliationRegimeUseCase extends UseCaseWithReturn<AffiliationRegimeDomain, List<AffiliationRegimeEntity>>{

}
