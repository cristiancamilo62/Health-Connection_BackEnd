package com.healthconnection.application.usecase.healthprofessional.impl;

import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;
import com.healthconnection.application.secondaryports.mapper.concrete.HealthProfessionalMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.healthprofessional.HealthProfessionalRepository;
import com.healthconnection.application.usecase.healthprofessional.RegisterHealthProfessionalUseCase;
import com.healthconnection.application.usecase.healthprofessional.impl.rules.RegisterHealthProfessionalRuleDomainValidator;
import com.healthconnection.application.usecase.healthprofessional.validator.RegisterHealthProfessionalRuleValidator;
import com.healthconnection.application.usecase.notification.NotificationUseCase;
import com.healthconnection.application.usecase.role.ConsultRoleUseCase;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;

@Service
public class RegisterHealthProfessionalUseCaseImpl implements RegisterHealthProfessionalUseCase{

	private final RegisterHealthProfessionalRuleValidator registerHealthProfessionalRuleValidator;
	private final RegisterHealthProfessionalRuleDomainValidator registerHealthProfessionalRuleDomainValidator;
	private final HealthProfessionalRepository healthProfessionalRepository;
	private final HealthProfessionalMapperEntity healthProfessionalMapperEntity;
	private final NotificationUseCase notificationUseCase;
	private final ConsultRoleUseCase consultRoleUseCase;
	private final PasswordEncoder passwordEncoder;

	public RegisterHealthProfessionalUseCaseImpl(
			RegisterHealthProfessionalRuleValidator registerHealthProfessionalRuleValidator,
			RegisterHealthProfessionalRuleDomainValidator registerHealthProfessionalRuleDomainValidator,
			HealthProfessionalRepository healthProfessionalRepository,
			HealthProfessionalMapperEntity healthProfessionalMapperEntity, NotificationUseCase notificationUseCase,
			ConsultRoleUseCase consultRoleUseCase,PasswordEncoder passwordEncoder) {
		super();
		this.registerHealthProfessionalRuleValidator = registerHealthProfessionalRuleValidator;
		this.registerHealthProfessionalRuleDomainValidator = registerHealthProfessionalRuleDomainValidator;
		this.healthProfessionalRepository = healthProfessionalRepository;
		this.healthProfessionalMapperEntity = healthProfessionalMapperEntity;
		this.notificationUseCase = notificationUseCase;
		this.consultRoleUseCase = consultRoleUseCase;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void execute(HealthProfessionalDomain healthProfessionalDomain) {
		
		healthProfessionalDomain.setId(UUID.randomUUID());
		
		registerHealthProfessionalRuleValidator.validate(healthProfessionalDomain);
		
		registerHealthProfessionalRuleDomainValidator.validate(healthProfessionalDomain);
		
		HealthProfessionalEntity healthProfessionalEntity = healthProfessionalMapperEntity.toEntity(healthProfessionalDomain);
		
		String encodedPassword = passwordEncoder.encode(healthProfessionalEntity.getPassword());
		
		healthProfessionalEntity.setPassword(encodedPassword);
		
		healthProfessionalEntity.setRole(consultRoleUseCase.execute(healthProfessionalEntity.getEmail()));
		
		healthProfessionalRepository.save(healthProfessionalEntity);
		
		notificationUseCase.sendEmail(healthProfessionalEntity.getEmail(), healthProfessionalEntity.getFirstName());
		
	}

}
