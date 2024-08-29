package com.healthconnection.application.usecase.servicetype;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.ServiceTypeEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;
import com.healthconnection.domain.servicetype.ServiceTypeDomain;

@Service
public interface ConsultServiceTypeUseCase extends UseCaseWithReturn<ServiceTypeDomain, List<ServiceTypeEntity>>{

}
