package com.healthconnection.application.usecase.healthprofessional;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public interface ConsultHealthprofessionalUseCase extends UseCaseWithReturn<HealthProfessionalDomain, List<HealthProfessionalEntity>>{

}
