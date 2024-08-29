package com.healthconnection.application.primaryports.interactor.servicetype;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.primaryports.dto.ServiceTypeDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;
import com.healthconnection.application.secondaryports.entity.ServiceTypeEntity;

@Service
public interface ConsultServiceTypeInteractor extends InteractorWithReturn<ServiceTypeDTO, List<ServiceTypeEntity>>{

}
