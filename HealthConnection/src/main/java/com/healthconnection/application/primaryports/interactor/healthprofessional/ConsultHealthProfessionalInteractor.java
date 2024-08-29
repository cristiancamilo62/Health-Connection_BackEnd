package com.healthconnection.application.primaryports.interactor.healthprofessional;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.HealthProfessionalDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;

@Service
public interface ConsultHealthProfessionalInteractor extends InteractorWithReturn<HealthProfessionalDTO, List<HealthProfessionalEntity>>{

}
