package com.healthconnection.application.usecase.appointment.impl.rules.domain;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.appointment.exceptions.StartDateDoesNotBeforeEndDateAppointmentException;
import com.healthconnection.domain.appointment.AppointmentDomain;
import com.healthconnection.domain.appointment.rules.domain.StartDateDoesNotBeforeEndDateAppointmentRule;

@Service
public class StartDateDoesNotBeforeEndDateAppointmentRuleImpl implements StartDateDoesNotBeforeEndDateAppointmentRule{

	@Override
    public void execute(AppointmentDomain data) {
        LocalDateTime startDate = data.getStartDate();
        LocalDateTime endDate = data.getEndDate();

        if (startDate.isAfter(endDate)) {
            throw new StartDateDoesNotBeforeEndDateAppointmentException();
        }
    }
}
	
