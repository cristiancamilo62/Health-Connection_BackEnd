package com.healthconnection.application.usecase.appointment.impl.rules.domain;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.appointment.exceptions.StartDateDoesNotBeforeNowAppointmentException;
import com.healthconnection.domain.appointment.rules.domain.StartDateDoesNotBeforeNowAppointmentRule;

@Service
public class StartDateDoesNotBeforeNowAppointmentRuleImpl implements StartDateDoesNotBeforeNowAppointmentRule {

    @Override
    public void execute(LocalDateTime startDate) {
    	
        LocalDateTime currentDate = LocalDateTime.now();

        if (startDate.isBefore(currentDate)) {
            throw new StartDateDoesNotBeforeNowAppointmentException();
        }
    }
}

