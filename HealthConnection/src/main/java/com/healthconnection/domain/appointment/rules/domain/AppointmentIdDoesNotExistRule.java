package com.healthconnection.domain.appointment.rules.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.Rule;

@Service
public interface AppointmentIdDoesNotExistRule extends Rule<UUID>{

}
