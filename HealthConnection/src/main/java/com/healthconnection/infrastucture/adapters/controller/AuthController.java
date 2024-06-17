package com.healthconnection.infrastucture.adapters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.auth.AuthInteractor;
import com.healthconnection.crosscutting.exception.HealthException;
import com.healthconnection.crosscutting.helper.ObjectHelper;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	private AuthInteractor authInteractor;

	public AuthController(AuthInteractor authInteractor) {
	super();
	this.authInteractor = authInteractor;
}

	@GetMapping
    public String loginPage() {
        return "login";
    }
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody PatientDTO patientDTO) {
        
		if (ObjectHelper.isNull(patientDTO)) {
            logger.error("Solicitud de registro de cliente con datos nulos");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }

        logger.info("Registrando nuevo cliente: {}", patientDTO.getFirstName());

        try {
            var patienRegister = authInteractor.execute(patientDTO);
            logger.info("Cliente registrado exitosamente: {}", patientDTO.getFirstName());
            return ResponseEntity.status(HttpStatus.CREATED).body(patienRegister);
        } catch (final HealthException exception) {
            logger.error("error al registrar cliente A: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }catch (final Exception exception) {
            logger.error("Error al registrar cliente B: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
		
    }


}
