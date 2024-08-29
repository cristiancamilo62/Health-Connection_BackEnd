package com.healthconnection.application.primaryports.interactor.appointment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.AppointmentDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;

@Service
public interface ConsultAppointmentInteractor extends InteractorWithReturn<AppointmentDTO, List<AppointmentEntity>>{

}
