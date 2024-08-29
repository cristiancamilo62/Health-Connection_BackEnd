package com.healthconnection.application.usecase.role;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.RoleEntity;
import com.healthconnection.application.usecase.UseCaseWithReturn;

@Service
public interface ConsultRoleUseCase extends UseCaseWithReturn<String, RoleEntity>{

}
