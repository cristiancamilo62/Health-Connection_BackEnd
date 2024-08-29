package com.healthconnection.domain.healthprofessional.rules.validators;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.Rule;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public interface NameHealthProfessionalRuleValidator extends Rule<HealthProfessionalDomain>{

}
