package com.healthconnection.application.usecase.appointment.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.AppointmentMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.appointment.AppointmentRepository;
import com.healthconnection.application.usecase.appointment.ConsultAppointmentUseCase;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.appointment.AppointmentDomain;

@Service
public class ConsultAppointmentUseCaseImpl implements ConsultAppointmentUseCase{
	
	private final AppointmentRepository appointmentRepository;
	private final AppointmentMapperEntity appointmentMapperEntity;

	public ConsultAppointmentUseCaseImpl(AppointmentRepository appointmentRepository,
			AppointmentMapperEntity appointmentMapperEntity) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.appointmentMapperEntity = appointmentMapperEntity;
	}


	@Override
	public List<AppointmentEntity> execute(AppointmentDomain appointmentDomain) {

		AppointmentEntity appointmentEntity = appointmentMapperEntity.toEntity(appointmentDomain);
		
		
		 System.out.println("domain "+ appointmentEntity.getHealthProfessional().getDateBirth());
		 
		 System.out.println(appointmentEntity.getHealthProfessional().getDateBirth());
		 
		if (UuidHelper.isDefaultOrNull(appointmentEntity.getHealthProfessional().getId()) ||
				(appointmentEntity.getHealthProfessional() == null ||
	        (UuidHelper.isUuidEmpty(appointmentEntity.getHealthProfessional().getId()) ))) {
			appointmentEntity.setHealthProfessional(null);
	    }
	    if (UuidHelper.isUuidEmpty(appointmentEntity.getAppointmentServiceData().getCode()) ||
	    		(appointmentEntity.getAppointmentServiceData() != null || 
	        (UuidHelper.isDefault(appointmentEntity.getAppointmentServiceData().getCode())))) {
	    	appointmentEntity.setAppointmentServiceData(null);
	    }
	    
	    appointmentEntity.setEndDate(null);
	    
	    
	    
	    ExampleMatcher matcher = ExampleMatcher.matching()
	    		.withIgnorePaths("code")
	    		.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
	    
	    Example<AppointmentEntity> example = Example.of(appointmentEntity,matcher);
	   
	    
	    return appointmentRepository.findAll(example);
		
	}

}
