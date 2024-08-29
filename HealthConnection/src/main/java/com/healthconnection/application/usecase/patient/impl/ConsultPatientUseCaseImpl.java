package com.healthconnection.application.usecase.patient.impl;

import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.PatientMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.usecase.patient.ConsultPatientUseCase;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.patient.PatientDomain;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultPatientUseCaseImpl implements ConsultPatientUseCase {

    private final PatientRepository patientRepository;
    private final PatientMapperEntity patientMapperEntity;

    public ConsultPatientUseCaseImpl(PatientRepository patientRepository, PatientMapperEntity patientMapperEntity) {
        this.patientRepository = patientRepository;
        this.patientMapperEntity = patientMapperEntity;
    }

    @Override
    public List<PatientEntity> execute(PatientDomain patientDomain) {
    	
    	
        var patientEntity = patientMapperEntity.toEntity(patientDomain);

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

        return patientRepository.findAll(example);
    }
}

