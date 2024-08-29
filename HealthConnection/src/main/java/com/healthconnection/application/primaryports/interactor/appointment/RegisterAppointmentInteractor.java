package com.healthconnection.application.primaryports.interactor.appointment;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.AppointmentDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithoutReturn;

import jakarta.transaction.Transactional;

@Transactional
@Service
public interface RegisterAppointmentInteractor extends InteractorWithoutReturn<AppointmentDTO>{

}
