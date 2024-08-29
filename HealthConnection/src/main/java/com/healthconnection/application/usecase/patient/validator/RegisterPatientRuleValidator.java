package com.healthconnection.application.usecase.patient.validator;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.RuleValidator;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public interface RegisterPatientRuleValidator extends RuleValidator<PatientDomain>{

}
