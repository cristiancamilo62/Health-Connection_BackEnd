package com.healthconnection.application.usecase.patient.impl.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.RuleValidator;
import com.healthconnection.domain.patient.PatientDomain;


@Service
public interface RegisterPatientRuleDomainValidator extends RuleValidator<PatientDomain>{

}
