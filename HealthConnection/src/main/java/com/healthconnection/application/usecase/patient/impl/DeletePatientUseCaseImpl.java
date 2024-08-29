package com.healthconnection.application.usecase.patient.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.PatientMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.DeletePatientUseCase;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.patient.PatientDomain;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;


@Service
public class DeletePatientUseCaseImpl implements DeletePatientUseCase {

    private final PatientRepository patientRepository;
    private final PatientMapperEntity patientMapperEntity;

    public DeletePatientUseCaseImpl(PatientRepository patientRepository, PatientMapperEntity patientMapperEntity) {
        this.patientRepository = patientRepository;
        this.patientMapperEntity = patientMapperEntity;
    }

    @Override
    public void execute(PatientDomain patient) {
        // Map the domain object to an entity object
        PatientEntity patientEntity = patientMapperEntity.toEntity(patient);
        
        // Handle default or empty UUIDs
        if (UuidHelper.isDefault(patientEntity.getIdentificationType().getId()) || UuidHelper.isUuidEmpty(patientEntity.getIdentificationType().getId())) {
            patientEntity.setIdentificationType(null);
        }
        if (UuidHelper.isDefault(patientEntity.getAffiliationRegime().getId()) || UuidHelper.isUuidEmpty(patientEntity.getAffiliationRegime().getId())) {
            patientEntity.setAffiliationRegime(null);
        }
        if (UuidHelper.isDefault(patientEntity.getEps().getId()) || UuidHelper.isUuidEmpty(patientEntity.getEps().getId())) {
            patientEntity.setEps(null);
        }
        if (UuidHelper.isDefault(patientEntity.getRole().getId()) || UuidHelper.isUuidEmpty(patientEntity.getRole().getId())) {
            patientEntity.setRole(null);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<PatientEntity> example = Example.of(patientEntity, matcher);

        patientRepository.delete((PatientEntity) example);
       
    }

}
