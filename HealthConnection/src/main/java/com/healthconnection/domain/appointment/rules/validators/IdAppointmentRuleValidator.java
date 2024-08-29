package com.healthconnection.domain.appointment.rules.validators;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.domain.Rule;

@Service
public interface IdAppointmentRuleValidator extends Rule<UUID>{

}
