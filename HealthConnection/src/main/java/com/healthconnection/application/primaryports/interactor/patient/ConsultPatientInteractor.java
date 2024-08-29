package com.healthconnection.application.primaryports.interactor.patient;

import java.util.List;

import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;
import com.healthconnection.application.secondaryports.entity.PatientEntity;

import jakarta.transaction.Transactional;

@Transactional
@Service
public interface ConsultPatientInteractor extends InteractorWithReturn<PatientDTO, List<PatientEntity>>{


}
