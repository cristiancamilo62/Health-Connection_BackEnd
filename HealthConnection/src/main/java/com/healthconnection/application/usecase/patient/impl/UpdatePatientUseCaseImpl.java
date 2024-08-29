package com.healthconnection.application.usecase.patient.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.mapper.concrete.PatientMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.UpdatePatientUseCase;
import com.healthconnection.application.usecase.patient.exceptions.PatientIdDoesNotExisteException;
import com.healthconnection.application.usecase.patient.validator.RegisterPatientRuleValidator;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public class UpdatePatientUseCaseImpl implements UpdatePatientUseCase{

    private final RegisterPatientRuleValidator registerPatientRuleValidator;
    private final PatientMapperEntity patientMapperEntity;
    private final PatientRepository patientRepository;
	
	public UpdatePatientUseCaseImpl(RegisterPatientRuleValidator registerPatientRuleValidator,
			PatientMapperEntity patientMapperEntity,PatientRepository patientRepository) {
		super();
		this.registerPatientRuleValidator = registerPatientRuleValidator;
		this.patientMapperEntity = patientMapperEntity;
		this.patientRepository = patientRepository;
	}




	@Override
	public void execute(PatientDomain patient) {
		
		if(!patientRepository.existsById(patient.getId())) {
			throw new PatientIdDoesNotExisteException();
		}
		
		registerPatientRuleValidator.validate(patient);
        
        var patientEntity = patientMapperEntity.toEntity(patient);    
        
        patientRepository.save(patientEntity);
		
	}

}
