package com.healthconnection.application.primaryports.interactor.identificationtye;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.IdentificationTypeDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;
import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;

@Service
public interface ConsultIdentificationTypeInteractor extends InteractorWithReturn<IdentificationTypeDTO, List<IdentificationTypeEntity>>{

}
