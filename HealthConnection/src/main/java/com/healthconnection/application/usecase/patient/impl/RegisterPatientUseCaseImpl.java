package com.healthconnection.application.usecase.patient.impl;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.healthconnection.application.secondaryports.mapper.concrete.PatientMapperEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.secondaryports.repository.concrete.varificationtoken.VerificationTokenRepository;
import com.healthconnection.application.usecase.notification.NotificationUseCase;
import com.healthconnection.application.usecase.patient.RegisterPatientUseCase;
import com.healthconnection.application.usecase.patient.impl.rules.RegisterPatientRuleDomainValidator;
import com.healthconnection.application.usecase.patient.validator.RegisterPatientRuleValidator;
import com.healthconnection.application.usecase.role.ConsultRoleUseCase;
import com.healthconnection.application.usecase.verificationtoken.VerificationTokenUseCase;
import com.healthconnection.domain.patient.PatientDomain;
import com.healthconnection.application.secondaryports.entity.VerificationTokenEntity;

@Service
public class RegisterPatientUseCaseImpl implements RegisterPatientUseCase {

    private final RegisterPatientRuleDomainValidator registerPatientRuleDomainValidator;
    private final RegisterPatientRuleValidator registerPatientRuleValidator;
    private final PatientMapperEntity patientMapperEntity;
    private final PatientRepository patientRepository;
    private final NotificationUseCase notificationUseCase;
    private final ConsultRoleUseCase consultRoleUseCase;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenUseCase verificationTokenUseCase;
    private final VerificationTokenRepository verificationTokenRepository;

    public RegisterPatientUseCaseImpl(
            RegisterPatientRuleDomainValidator registerPatientRuleDomainValidator,
            RegisterPatientRuleValidator registerPatientRuleValidator, 
            PatientMapperEntity patientMapperEntity,
            PatientRepository patientRepository, 
            NotificationUseCase notificationUseCase,
            ConsultRoleUseCase consultRoleUseCase,
            PasswordEncoder passwordEncoder,
            VerificationTokenUseCase verificationTokenUseCase,
            VerificationTokenRepository verificationTokenRepository) {
        this.registerPatientRuleDomainValidator = registerPatientRuleDomainValidator;
        this.registerPatientRuleValidator = registerPatientRuleValidator;
        this.patientMapperEntity = patientMapperEntity;
        this.patientRepository = patientRepository;
        this.notificationUseCase = notificationUseCase;
        this.consultRoleUseCase = consultRoleUseCase;
        this.passwordEncoder = passwordEncoder;
        this.verificationTokenUseCase = verificationTokenUseCase;
        this.verificationTokenRepository = verificationTokenRepository;
    }

    @Override
    public void execute(final PatientDomain patientDomain) {
        patientDomain.setId(UUID.randomUUID());
        
        registerPatientRuleValidator.validate(patientDomain);
        registerPatientRuleDomainValidator.validate(patientDomain);
        
        var patientEntity = patientMapperEntity.toEntity(patientDomain);
        String encodedPassword = passwordEncoder.encode(patientEntity.getPassword());
        patientEntity.setPassword(encodedPassword);
        patientEntity.setRole(consultRoleUseCase.execute(patientEntity.getEmail()));
        
        // Guardar paciente primero
        patientRepository.save(patientEntity);
        
        // Generar y guardar el token de verificación
        String token = UUID.randomUUID().toString();
        VerificationTokenEntity tokenEntity = new VerificationTokenEntity();
        tokenEntity.setToken(token);
        tokenEntity.setExpiryDate(LocalDateTime.now().plusHours(24)); // Token válido por 24 horas
        tokenEntity.setPatientEntity(patientEntity);
        verificationTokenRepository.save(tokenEntity);

        // Enviar correo con el token
        notificationUseCase.sendEmail(patientEntity.getEmail(), token);
    }
}
