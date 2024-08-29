package com.healthconnection.application.usecase.healthprofessional;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.UseCaseWithoutReturn;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public interface RegisterHealthProfessionalUseCase extends UseCaseWithoutReturn<HealthProfessionalDomain>{

}
