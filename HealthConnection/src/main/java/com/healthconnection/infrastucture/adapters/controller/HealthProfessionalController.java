package com.healthconnection.infrastucture.adapters.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthconnection.application.primaryports.dto.HealthProfessionalDTO;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.healthprofessional.ConsultHealthProfessionalInteractor;
import com.healthconnection.application.primaryports.interactor.healthprofessional.RegisterHealthProfessionalInteractor;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.usecase.patient.exceptions.EmptyPatientBodyException;
import com.healthconnection.crosscutting.helper.ObjectHelper;

@RestController
@RequestMapping("/api/v1/professional")
public class HealthProfessionalController {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthProfessionalController.class);
	private final RegisterHealthProfessionalInteractor registerHealthProfessionalInteractor;
	private final ConsultHealthProfessionalInteractor consultHealthProfessionalInteractor;
	

	
	public HealthProfessionalController(RegisterHealthProfessionalInteractor registerHealthProfessionalInteractor,
			ConsultHealthProfessionalInteractor consultHealthProfessionalInteractor) {
		super();
		this.registerHealthProfessionalInteractor = registerHealthProfessionalInteractor;
		this.consultHealthProfessionalInteractor = consultHealthProfessionalInteractor;
	}

	@GetMapping("dummy")
	public HealthProfessionalDTO obtainDummy() {
		return new HealthProfessionalDTO();
	}
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody HealthProfessionalDTO healthProfessionalDTO) {

        try {
        	
            if (ObjectHelper.isNull(healthProfessionalDTO)) {
                throw new EmptyPatientBodyException();
            }

            logger.info("Registering new patient: {}", healthProfessionalDTO.getFirstName());

            registerHealthProfessionalInteractor.execute(healthProfessionalDTO);

            logger.info("Patient registered successfully: {}", healthProfessionalDTO.getFirstName());

            return ResponseEntity.status(HttpStatus.CREATED).body("Your account has been created successfully");
        } catch (EmptyPatientBodyException exception) {
            logger.error("Client registration request with null data");
            return ResponseEntity.badRequest().body(exception.getMessage());
        } 
    }
	
	@PostMapping("/consultar")
    public ResponseEntity<List<HealthProfessionalEntity>> consult(@RequestBody HealthProfessionalDTO healthProfessionalDTO){
    	
    	var healthProfessionalEntity = consultHealthProfessionalInteractor.execute(healthProfessionalDTO);
    	
    	return ResponseEntity.ok(healthProfessionalEntity);
    }
    

}
