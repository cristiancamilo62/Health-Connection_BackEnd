package com.healthconnection.infrastucture.adapters.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthconnection.application.primaryports.dto.EpsDTO;
import com.healthconnection.application.primaryports.interactor.eps.ConsultEpsInteractor;
import com.healthconnection.application.secondaryports.entity.EpsEntity;

@RestController
@RequestMapping("/api/v1/eps")
public class EpsController {
	
	private final ConsultEpsInteractor consultEpsInteractor;
	
	public EpsController(ConsultEpsInteractor consultEpsInteractor) {
		super();
		this.consultEpsInteractor = consultEpsInteractor;
	}

	@GetMapping("/dummy")
	public EpsDTO obtainDummy() {
		return new EpsDTO();
	}
	
	@PostMapping("/consultar")
	public ResponseEntity<List<EpsEntity>> consultEps(@RequestBody EpsDTO epsDTO){
		
		var epsEntity = consultEpsInteractor.execute(epsDTO);
    	
    	return ResponseEntity.ok(epsEntity);
    }
	

}
