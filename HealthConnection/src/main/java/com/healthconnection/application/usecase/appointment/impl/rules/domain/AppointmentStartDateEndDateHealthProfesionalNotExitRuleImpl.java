package com.healthconnection.application.usecase.appointment.impl.rules.domain;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.AppointmentMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.appointment.AppointmentRepository;
import com.healthconnection.application.usecase.appointment.exceptions.AppointmentStartDateEndDateHealthProfesionalNotExistException;
import com.healthconnection.domain.appointment.AppointmentDomain;
import com.healthconnection.domain.appointment.rules.AppointmentStartDateEndDateHealthProfesionalNotExistRule;


@Service
public class AppointmentStartDateEndDateHealthProfesionalNotExitRuleImpl implements AppointmentStartDateEndDateHealthProfesionalNotExistRule{

	private AppointmentRepository appointmentRepository;
	private AppointmentMapperEntity appointmentMapperEntity;

	public AppointmentStartDateEndDateHealthProfesionalNotExitRuleImpl(AppointmentRepository appointmentRepository,
			AppointmentMapperEntity appointmentMapperEntity) {
		this.appointmentRepository = appointmentRepository;
		this.appointmentMapperEntity = appointmentMapperEntity;
	}





	@Override
	public void execute(AppointmentDomain appointmentDomain) {
		
		AppointmentEntity appointmentEntity = appointmentMapperEntity.toEntity(appointmentDomain);
		
		var results = appointmentRepository.existsByStartDateAndEndDateAndHealthProfessional(appointmentEntity.getStartDate(),
				appointmentEntity.getEndDate(), appointmentEntity.getHealthProfessional());
		
		if(results) {
			throw new AppointmentStartDateEndDateHealthProfesionalNotExistException();
		}
		
		
	}
}
