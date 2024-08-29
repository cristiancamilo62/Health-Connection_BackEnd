package com.healthconnection.application.usecase.eps;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.EpsEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;
import com.healthconnection.domain.eps.EpsDomain;

@Service
public interface ConsultEpsUseCase extends UseCaseWithReturn<EpsDomain, List<EpsEntity>>{

}
