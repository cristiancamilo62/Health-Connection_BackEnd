package com.healthconnection.application.usecase.appointment.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.AppointmentMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.appointment.AppointmentRepository;
import com.healthconnection.application.usecase.appointment.RegisterAppointmentUseCase;
import com.healthconnection.application.usecase.appointment.impl.rules.RegisterAppointmentRuleValidator;
import com.healthconnection.domain.appointment.AppointmentDomain;


@Service
public class RegisterAppointmentUseCaseImpl implements RegisterAppointmentUseCase{
	
	private final RegisterAppointmentRuleValidator registerAppointmentRuleValidator;
	private final AppointmentMapperEntity appointmentMapperEntity;
	private final AppointmentRepository appointmentRepository;

	public RegisterAppointmentUseCaseImpl(RegisterAppointmentRuleValidator registerAppointmentRuleValidator,
			AppointmentMapperEntity appointmentMapperEntity, AppointmentRepository appointmentRepository) {
		this.registerAppointmentRuleValidator = registerAppointmentRuleValidator;
		this.appointmentMapperEntity = appointmentMapperEntity;
		this.appointmentRepository = appointmentRepository;
	}

	@Override
	public void execute(AppointmentDomain appointmentDomain) {
		
		appointmentDomain.setId(UUID.randomUUID());
		
		registerAppointmentRuleValidator.validate(appointmentDomain);
		
		AppointmentEntity appointmentEntity =  appointmentMapperEntity.toEntity(appointmentDomain);
		
		
		appointmentRepository.save(appointmentEntity);
		
	}
	

	

}
