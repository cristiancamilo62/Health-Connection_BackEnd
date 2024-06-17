package com.healthconnection.domain.appointment.rules;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.DomainRule;

@Service
public interface StartDateDoesNotBeforeNowAppointmentRule extends DomainRule<Date>{

}
