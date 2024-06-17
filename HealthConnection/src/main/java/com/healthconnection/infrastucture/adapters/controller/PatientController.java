package com.healthconnection.infrastucture.adapters.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.application.primaryports.interactor.patient.RegisterPatientInteractor;
import com.healthconnection.application.usecase.patient.exceptions.EmptyPatientBodyException;
import com.healthconnection.crosscutting.exception.HealthException;
import com.healthconnection.crosscutting.helper.ObjectHelper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    private final RegisterPatientInteractor registerPatientInteractor;

    public PatientController(RegisterPatientInteractor registerPatientInteractor) {
        this.registerPatientInteractor = registerPatientInteractor;
    }

    @GetMapping("dummy")
    public PatientDTO obtener() {
        logger.info("Obteniendo dummy");
        return new PatientDTO();
    }

    @PostMapping
    public ResponseEntity<String> register(@Valid @RequestBody(required = false) PatientDTO patientDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String errorMessage = fieldError != null ? fieldError.getDefaultMessage() : "Unknown error";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }

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
            return ResponseEntity.badRequest().body("Error registering client: No data entered");
        } catch (HealthException exception) {
            logger.error("Error registering client: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering client: " + exception.getMessage());
        } catch (Exception exception) {
            logger.error("Error registering client: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering client: " + exception.getMessage());
        }
    }
}
