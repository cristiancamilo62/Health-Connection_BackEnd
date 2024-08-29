package com.healthconnection.infrastucture.adapters.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.patient.ConsultPatientInteractor;
import com.healthconnection.application.primaryports.interactor.patient.DeletePatientInteractor;
import com.healthconnection.application.primaryports.interactor.patient.RegisterPatientInteractor;
import com.healthconnection.application.primaryports.interactor.patient.UpdatePatientInteractor;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.usecase.patient.exceptions.EmptyPatientBodyException;
import com.healthconnection.crosscutting.helper.ObjectHelper;


@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
    private final RegisterPatientInteractor registerPatientInteractor;
    private final ConsultPatientInteractor consultPatientInteractor;
    private final DeletePatientInteractor deletePatientInteractor;
    private final UpdatePatientInteractor updatePatientInteractor;

	

	public PatientController(RegisterPatientInteractor registerPatientInteractor,
			ConsultPatientInteractor consultPatientInteractor, DeletePatientInteractor deletePatientInteractor,
			UpdatePatientInteractor updatePatientInteractor) {
		super();
		this.registerPatientInteractor = registerPatientInteractor;
		this.consultPatientInteractor = consultPatientInteractor;
		this.deletePatientInteractor = deletePatientInteractor;
		this.updatePatientInteractor = updatePatientInteractor;
	}

	@GetMapping("/dummy")
    public PatientDTO obtener() {
        logger.info("Obteniendo dummy");
        return new PatientDTO();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody PatientDTO patientDTO) {

        try {
        	
            if (ObjectHelper.isNull(patientDTO)) {
                throw new EmptyPatientBodyException();
            }

            logger.info("Registering new patient: {}", patientDTO.getFirstName());

            registerPatientInteractor.execute(patientDTO);

            logger.info("Patient registered successfully: {}", patientDTO.getFirstName());

            return ResponseEntity.status(HttpStatus.CREATED).body("Your account has been created successfully");
        } catch (EmptyPatientBodyException exception) {
            logger.error("Client registration request with null data");
            return ResponseEntity.badRequest().body(exception.getMessage());
        } 
    }
    
    @PostMapping("/consultar")
    public ResponseEntity<List<PatientEntity>> consult(@RequestBody PatientDTO patientDTO){
    	
    	var patientEntity = consultPatientInteractor.execute(patientDTO);
    	
    	return ResponseEntity.ok(patientEntity);
    }
    
    @PutMapping("/update")
    public ResponseEntity<String> updatePatient(@RequestBody PatientDTO patientDTO) {
        try {
            if (ObjectHelper.isNull(patientDTO)) {
                throw new EmptyPatientBodyException();
            }

            logger.info("Updating patient: {}", patientDTO.getFirstName());

            updatePatientInteractor.execute(patientDTO);

            logger.info("Patient updated successfully: {}", patientDTO.getFirstName());

            return ResponseEntity.status(HttpStatus.CREATED).body("Your account has been updated successfully.");
        } catch (final EmptyPatientBodyException exception) {
            logger.error("Update request with null data");
            return ResponseEntity.badRequest().body(exception.getMessage());
        } 
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePatient(@RequestBody PatientDTO patientDTO) {
        try {
            if (ObjectHelper.isNull(patientDTO)) {
                throw new EmptyPatientBodyException();
            }

            logger.info("Deleting patient: {}", patientDTO.getFirstName());

            deletePatientInteractor.execute(patientDTO);

            logger.info("Patient deleted successfully: {}", patientDTO.getFirstName());

            return ResponseEntity.status(HttpStatus.OK).body("Your account has been deleted successfully.");
        } catch (final EmptyPatientBodyException exception) {
            logger.error("Delete request with null data");
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/me")
    public ResponseEntity<PatientEntity> getAuthenticatedPatient(@AuthenticationPrincipal UserDetails userDetails) {
    	
        String email = userDetails.getUsername();
        
        var patientDTO = new PatientDTO(null, "", "", "", "", "", email, false, "", false, "", "", null, null, null, true, null);
        patientDTO.setEmail(email);
        
        
        var patientRegister = consultPatientInteractor.execute(patientDTO);
        if (!patientRegister.isEmpty()) {
        	var authenticatedPatient = patientRegister.get(0);
            return ResponseEntity.ok(authenticatedPatient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    
}
