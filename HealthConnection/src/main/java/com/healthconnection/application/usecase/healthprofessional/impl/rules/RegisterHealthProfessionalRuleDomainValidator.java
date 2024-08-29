package com.healthconnection.application.usecase.healthprofessional.impl.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.RuleValidator;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public interface RegisterHealthProfessionalRuleDomainValidator extends RuleValidator<HealthProfessionalDomain>{

}
