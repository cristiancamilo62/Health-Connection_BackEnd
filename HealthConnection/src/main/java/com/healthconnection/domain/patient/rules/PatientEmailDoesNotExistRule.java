package com.healthconnection.domain.patient.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.DomainRule;

@Service
public interface PatientEmailDoesNotExistRule extends DomainRule<String>{

}
 