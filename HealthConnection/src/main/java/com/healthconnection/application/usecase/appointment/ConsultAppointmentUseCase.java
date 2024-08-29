package com.healthconnection.application.usecase.appointment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Service
public interface ConsultAppointmentUseCase extends UseCaseWithReturn<AppointmentDomain, List<AppointmentEntity>>{

}
