package com.healthconnection.infrastucture.adapters.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthconnection.application.primaryports.dto.IdentificationTypeDTO;
import com.healthconnection.application.primaryports.interactor.identificationtye.ConsultIdentificationTypeInteractor;
import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;

@RestController
@RequestMapping("/api/v1/identifications")
public class IdentificationTypeController {
	
	private final ConsultIdentificationTypeInteractor consultIdentificationTypeInteractor;

	public IdentificationTypeController(ConsultIdentificationTypeInteractor consultIdentificationTypeInteractor) {
		super();
		this.consultIdentificationTypeInteractor = consultIdentificationTypeInteractor;
	}
	
	@GetMapping("/dummy")
	public IdentificationTypeDTO obtainDummy() {
		return new IdentificationTypeDTO();
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<List<IdentificationTypeEntity>> consultIdentification(@RequestBody IdentificationTypeDTO identificationTypeDTO){
		
		var identificationTypeEntity = consultIdentificationTypeInteractor.execute(identificationTypeDTO);
    	
    	return ResponseEntity.ok(identificationTypeEntity);
    }
	

}
