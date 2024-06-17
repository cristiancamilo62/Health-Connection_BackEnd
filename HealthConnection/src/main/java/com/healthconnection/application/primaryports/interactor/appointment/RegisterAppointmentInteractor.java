package com.healthconnection.application.primaryports.interactor.appointment;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.AppointmentDTO;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Transactional
@Service
public interface RegisterAppointmentInteractor {
	
	void execute(AppointmentDTO appointmen);

}
