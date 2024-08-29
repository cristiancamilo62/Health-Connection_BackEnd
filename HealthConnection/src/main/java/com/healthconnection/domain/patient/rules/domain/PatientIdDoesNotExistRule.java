package com.healthconnection.domain.patient.rules.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.Rule;

@Service
public interface PatientIdDoesNotExistRule extends Rule<UUID>{

}
