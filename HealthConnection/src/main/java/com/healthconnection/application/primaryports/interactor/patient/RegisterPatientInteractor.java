package com.healthconnection.application.primaryports.interactor.patient;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.PatientDTO;

import jakarta.transaction.Transactional;


@Transactional
@Service
public interface RegisterPatientInteractor {
	
	void execute(PatientDTO patient);

}
