package com.healthconnection.domain.appointment.rules.domain;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.healthconnection.domain.Rule;

@Service
public interface StartDateDoesNotBeforeNowAppointmentRule extends Rule<LocalDateTime>{

}
