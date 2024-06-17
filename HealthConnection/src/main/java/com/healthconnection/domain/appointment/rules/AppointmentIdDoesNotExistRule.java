package com.healthconnection.domain.appointment.rules;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.DomainRule;

@Service
public interface AppointmentIdDoesNotExistRule extends DomainRule<UUID>{

}
