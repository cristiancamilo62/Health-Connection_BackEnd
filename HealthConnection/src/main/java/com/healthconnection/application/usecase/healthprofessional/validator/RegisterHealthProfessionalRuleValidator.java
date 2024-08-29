package com.healthconnection.application.usecase.healthprofessional.validator;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.RuleValidator;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public interface RegisterHealthProfessionalRuleValidator extends RuleValidator<HealthProfessionalDomain>{

}
