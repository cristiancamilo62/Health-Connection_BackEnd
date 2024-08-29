package com.healthconnection.domain.appointment.rules.validators;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.healthconnection.domain.Rule;

@Service
public interface StartDateAppointmentRuleValidator extends Rule<LocalDateTime>{

}
