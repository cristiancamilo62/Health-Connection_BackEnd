package com.healthconnection.application.primaryports.interactor.patient.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.patient.ConsultPatientInteractor;
import com.healthconnection.application.primaryports.mapper.concrete.PatientMapperDTO;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.usecase.patient.ConsultPatientUseCase;
import com.healthconnection.domain.patient.PatientDomain;
import java.util.List;

@Service
public class ConsultPatientInteractorImpl implements ConsultPatientInteractor {

    private final PatientMapperDTO patientMapperDTO;
    private final ConsultPatientUseCase consultPatientUseCase;

    public ConsultPatientInteractorImpl(PatientMapperDTO patientMapperDTO,
    		ConsultPatientUseCase consultPatientUseCase) {
        this.patientMapperDTO = patientMapperDTO;
        this.consultPatientUseCase = consultPatientUseCase;
    }

    @Override
    public List<PatientEntity> execute(PatientDTO patientDTO) {
        
    	PatientDomain patientDomain = patientMapperDTO.toDomain(patientDTO);
    	
        List<PatientEntity> patientEntities = consultPatientUseCase.execute(patientDomain);
        
        return patientEntities.stream().toList();
    }
}

