package com.healthconnection.application.usecase.patient;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.UseCaseWithoutReturn;
import com.healthconnection.domain.patient.PatientDomain;


@Service
public interface RegisterPatientUseCase extends UseCaseWithoutReturn<PatientDomain>{
	

}
