package com.healthconnection.domain.healthprofessional.rules.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.Rule;

@Service
public interface HealthProfessionalIdDoesNotExistRule extends Rule<UUID>{

}
