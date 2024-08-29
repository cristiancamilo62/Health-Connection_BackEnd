package com.healthconnection.domain.appointment.rules.domain;

import org.springframework.stereotype.Service;

import com.healthconnection.domain.Rule;
import com.healthconnection.domain.appointment.AppointmentDomain;


@Service
public interface AppointmentStartDateEndDateClinicNotExistRule extends Rule<AppointmentDomain>{
	
	

}
