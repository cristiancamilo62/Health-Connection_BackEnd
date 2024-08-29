package com.healthconnection.application.usecase.patient;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public interface ConsultPatientUseCase extends UseCaseWithReturn<PatientDomain, List<PatientEntity>>{

}
