package com.healthconnection.application.usecase.role.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.RoleEntity;
import com.healthconnection.application.secondaryports.repository.concrete.role.RoleRepository;
import com.healthconnection.application.usecase.role.ConsultRoleUseCase;
import com.healthconnection.application.usecase.role.exceptions.RoleNotFoundException;

@Service
public class ConsultRoleUseCaseImpl implements ConsultRoleUseCase{

	private final RoleRepository roleRepository;
	
	public ConsultRoleUseCaseImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public RoleEntity execute(String email) {

        String[] parts = email.split("@");
   
        String domain = parts[1]; 

        switch (domain) {
            case "gmail.com":
                return roleRepository.findByName("USER_ROLE");
            case "health.com":
                return roleRepository.findByName("HEALTH_ROLE");
            case "admin.com":
                return roleRepository.findByName("ADMIN_ROLE");
            default:
                throw new RoleNotFoundException();
        }
    }

}
