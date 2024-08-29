package com.healthconnection.application.usecase.appointment.validator;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.RuleValidator;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Service
public interface RegisterAppointmentRuleValidator extends RuleValidator<AppointmentDomain> {

}
