package com.healthconnection.application.usecase.appointment.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.AppointmentMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.appointment.AppointmentRepository;
import com.healthconnection.application.usecase.appointment.RegisterAppointmentUseCase;
import com.healthconnection.application.usecase.appointment.impl.rules.RegisterAppointmentRuleDomainValidator;
import com.healthconnection.application.usecase.appointment.validator.RegisterAppointmentRuleValidator;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Service
public class RegisterAppointmentUseCaseImpl implements RegisterAppointmentUseCase{
	
	private final RegisterAppointmentRuleDomainValidator registerAppointmentRuleDomainValidator;
	private final AppointmentMapperEntity appointmentMapperEntity;
	private final AppointmentRepository appointmentRepository;
	private final RegisterAppointmentRuleValidator registerAppointmentRuleValidator;


	public RegisterAppointmentUseCaseImpl(RegisterAppointmentRuleDomainValidator registerAppointmentRuleDomainValidator,
			AppointmentMapperEntity appointmentMapperEntity, AppointmentRepository appointmentRepository,
			RegisterAppointmentRuleValidator registerAppointmentRuleValidator) {
		super();
		this.registerAppointmentRuleDomainValidator = registerAppointmentRuleDomainValidator;
		this.appointmentMapperEntity = appointmentMapperEntity;
		this.appointmentRepository = appointmentRepository;
		this.registerAppointmentRuleValidator = registerAppointmentRuleValidator;
	}



	@Override
	public void execute(AppointmentDomain appointmentDomain) {
		
		appointmentDomain.setId(UUID.randomUUID());
		
		registerAppointmentRuleValidator.validate(appointmentDomain);
		
		registerAppointmentRuleDomainValidator.validate(appointmentDomain);
		
		AppointmentEntity appointmentEntity =  appointmentMapperEntity.toEntity(appointmentDomain);
		
		appointmentRepository.save(appointmentEntity);
		
	}
	

	

}
