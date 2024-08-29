package com.healthconnection.infrastucture.adapters.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthconnection.application.primaryports.dto.ServiceTypeDTO;
import com.healthconnection.application.primaryports.interactor.servicetype.ConsultServiceTypeInteractor;
import com.healthconnection.application.secondaryports.entity.ServiceTypeEntity;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceTypeController {
	
	private final ConsultServiceTypeInteractor consultServiceTypeInteractor;

	public ServiceTypeController(ConsultServiceTypeInteractor consultServiceTypeInteractor) {
		super();
		this.consultServiceTypeInteractor = consultServiceTypeInteractor;
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<List<ServiceTypeEntity>> consultIdentification(@RequestBody ServiceTypeDTO serviceTypeDTO){
		
		var serviceTypeEntity = consultServiceTypeInteractor.execute(serviceTypeDTO);
    	
    	return ResponseEntity.ok(serviceTypeEntity);
    }
}
