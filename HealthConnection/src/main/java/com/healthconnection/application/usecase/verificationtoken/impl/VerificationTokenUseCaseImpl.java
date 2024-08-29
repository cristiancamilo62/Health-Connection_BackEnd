package com.healthconnection.application.usecase.verificationtoken.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.secondaryports.entity.VerificationTokenEntity;
import com.healthconnection.application.secondaryports.repository.concrete.patient.PatientRepository;
import com.healthconnection.application.secondaryports.repository.concrete.varificationtoken.VerificationTokenRepository;
import com.healthconnection.application.usecase.verificationtoken.VerificationTokenUseCase;

import jakarta.transaction.Transactional;

@Service
public class VerificationTokenUseCaseImpl implements VerificationTokenUseCase {

    private static final Logger logger = LoggerFactory.getLogger(VerificationTokenUseCaseImpl.class);

    private final VerificationTokenRepository verificationTokenRepository;
    private final PatientRepository patientRepository;

    public VerificationTokenUseCaseImpl(VerificationTokenRepository verificationTokenRepository,
                                         PatientRepository patientRepository) {
        this.verificationTokenRepository = verificationTokenRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    @Transactional
    public Boolean execute(String token) {
        try {
            Optional<VerificationTokenEntity> verificationTokenOpt = verificationTokenRepository.findByToken(token);

            if (verificationTokenOpt.isPresent()) {
            	System.out.println("void a entarr"+ verificationTokenOpt);
                VerificationTokenEntity verificationTokenEntity = verificationTokenOpt.get();
                LocalDateTime now = LocalDateTime.now(); // Obtener la fecha y hora actuales

                // Verificar si el token no ha expirado
                if (verificationTokenEntity.getExpiryDate().isAfter(now)) {
                	System.out.println("voy por aca entre a cambiar : ");
                    // Token es válido
                    PatientEntity patient = verificationTokenEntity.getPatientEntity();
                    patient.setAccountStatement(true); // Activar al paciente
                    patientRepository.save(patient);
                    System.out.println("voy por aca entre a eliminar : ");

                    verificationTokenRepository.delete(verificationTokenEntity); // Eliminar el token después de usarlo
                    return true;
                } else {
                    logger.warn("Token has expired: {}", token);
                }
            } else {
                logger.warn("Token not found: {}", token);
            }
        } catch (Exception e) {
            logger.error("Error verifying token: ", e);
        }
        return false;
    }
}
