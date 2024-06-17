package com.healthconnection.domain.appointment.rules;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.DomainRule;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Service
public interface StartDateDoesNotBeforeEndDateAppointmentRule extends DomainRule<AppointmentDomain>{

}
