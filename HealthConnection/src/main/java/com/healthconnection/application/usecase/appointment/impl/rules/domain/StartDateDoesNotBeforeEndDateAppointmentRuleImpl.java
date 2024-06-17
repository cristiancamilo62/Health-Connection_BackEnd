package com.healthconnection.application.usecase.appointment.impl.rules.domain;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.appointment.exceptions.StartDateDoesNotBeforeEndDateAppointmentException;
import com.healthconnection.domain.appointment.AppointmentDomain;
import com.healthconnection.domain.appointment.rules.StartDateDoesNotBeforeEndDateAppointmentRule;



@Service
public class StartDateDoesNotBeforeEndDateAppointmentRuleImpl implements StartDateDoesNotBeforeEndDateAppointmentRule{

	@Override
    public void execute(AppointmentDomain data) {
        Date startDate = data.getStartDate();
        Date endDate = data.getEndDate();

        if (startDate.after(endDate)) {
            throw new StartDateDoesNotBeforeEndDateAppointmentException();
        }
    }
}
	
