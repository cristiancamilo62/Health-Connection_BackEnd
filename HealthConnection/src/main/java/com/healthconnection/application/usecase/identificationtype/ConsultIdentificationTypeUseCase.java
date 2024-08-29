package com.healthconnection.application.usecase.identificationtype;

import java.util.List;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;

@Service
public interface ConsultIdentificationTypeUseCase extends UseCaseWithReturn<IdentificationTypeDomain, List<IdentificationTypeEntity>>{

}
