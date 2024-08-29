package com.healthconnection.application.primaryports.interactor.eps;

import java.util.List;
import org.springframework.stereotype.Service;
import com.healthconnection.application.primaryports.dto.EpsDTO;
import com.healthconnection.application.primaryports.interactor.InteractorWithReturn;
import com.healthconnection.application.secondaryports.entity.EpsEntity;

@Service
public interface ConsultEpsInteractor extends InteractorWithReturn<EpsDTO, List<EpsEntity>>{

}
