package com.healthconnection.domain.patient.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.DomainRule;

@Service
public interface PatientIdDoesNotExistRule extends DomainRule<UUID>{

}
