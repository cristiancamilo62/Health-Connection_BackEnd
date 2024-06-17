package com.healthconnection.application.usecase.appointment.impl.rules.domain;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.appointment.exceptions.StartDateDoesNotBeforeNowAppointmentException;
import com.healthconnection.domain.appointment.rules.StartDateDoesNotBeforeNowAppointmentRule;


@Service
public class StartDateDoesNotBeforeNowAppointmentRuleImpl implements StartDateDoesNotBeforeNowAppointmentRule {

    @Override
    public void execute(Date startDate) {
    	
        LocalDate currentDate = LocalDate.now();

        LocalDate startDateLocal = startDate.toLocalDate();

        if (startDateLocal.isBefore(currentDate)) {
            throw new StartDateDoesNotBeforeNowAppointmentException();
        }
    }
}
