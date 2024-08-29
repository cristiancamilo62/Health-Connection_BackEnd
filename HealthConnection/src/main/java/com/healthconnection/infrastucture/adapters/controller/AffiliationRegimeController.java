package com.healthconnection.infrastucture.adapters.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthconnection.application.primaryports.dto.AffiliationRegimeDTO;
import com.healthconnection.application.primaryports.interactor.affiliationregime.ConsultAffiliationRegimeInteractor;
import com.healthconnection.application.secondaryports.entity.AffiliationRegimeEntity;


@RestController
@RequestMapping("/api/v1/affiliationregime")
public class AffiliationRegimeController {
	
	private final ConsultAffiliationRegimeInteractor consultAffiliationRegimeInteractor;
	
	public AffiliationRegimeController(ConsultAffiliationRegimeInteractor consultAffiliationRegimeInteractor) {
		super();
		this.consultAffiliationRegimeInteractor = consultAffiliationRegimeInteractor;
	}

	@GetMapping("/dummy")
	public AffiliationRegimeDTO obtainDummy() {
		return new AffiliationRegimeDTO();
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<List<AffiliationRegimeEntity>> consultAffilistionRegime(@RequestBody AffiliationRegimeDTO affiliationRegimeDTO){
		
		var affiliationRegimeEntity = consultAffiliationRegimeInteractor.execute(affiliationRegimeDTO);
    	
    	return ResponseEntity.ok(affiliationRegimeEntity);
    }

}
