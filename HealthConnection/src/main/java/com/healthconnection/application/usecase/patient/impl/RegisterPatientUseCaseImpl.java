package com.healthconnection.application.usecase.patient.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.RoleEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.PatientMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.secondaryports.repository.concrete.role.RoleRepository;
import com.healthconnection.application.usecase.notification.NotificationUseCase;
import com.healthconnection.application.usecase.patient.RegisterPatientUseCase;
import com.healthconnection.application.usecase.patient.impl.rules.RegisterPatientRuleValidator;
import com.healthconnection.domain.patient.PatientDomain;

@Service
public class RegisterPatientUseCaseImpl implements RegisterPatientUseCase {

    private final RegisterPatientRuleValidator registerPatientRuleValidator;
    private final PatientMapperEntity patientMapperEntity;
    private final PatientRepository patientRepository;
    private final NotificationUseCase notificationUseCase;
    private final RoleRepository roleRepository;


	public RegisterPatientUseCaseImpl(RegisterPatientRuleValidator registerPatientRuleValidator,
			PatientMapperEntity patientMapperEntity, PatientRepository patientRepository,
			NotificationUseCase notificationUseCase,RoleRepository roleRepository ) {
		super();
		this.registerPatientRuleValidator = registerPatientRuleValidator;
		this.patientMapperEntity = patientMapperEntity;
		this.patientRepository = patientRepository;
		this.notificationUseCase = notificationUseCase;
		this.roleRepository = roleRepository;
	}
	
	@Override
    public void execute(PatientDomain patientDomain) {
		
		patientDomain.setId(UUID.randomUUID());
		
        registerPatientRuleValidator.validate(patientDomain);  
        
        var patientEntity = patientMapperEntity.toEntity(patientDomain);    
        
        patientEntity.setRole(getRoleEmail(patientEntity.getEmail()));
        
        patientRepository.save(patientEntity);
        
        notificationUseCase.sendEmail(patientEntity.getEmail(),patientEntity.getFirstName());
        
    }
	
	public RoleEntity getRoleEmail(String email) {
		
		String[] partsEmail = email.split("@");
		
		String domain = partsEmail[1];

		
		if(domain.equals("gmail.com")) {
			return roleRepository.findByName("USER_ROLE");
		}
		return null;
	
	}
	
	
}

