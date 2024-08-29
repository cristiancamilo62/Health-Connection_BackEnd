package com.healthconnection.infrastucture.adapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthconnection.application.primaryports.dto.PatientDTO;
import com.healthconnection.crosscutting.helper.JwtUtil;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private JwtUtil jwtUtil;
	private AuthenticationManager authenticationManager;
	
	public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
		super();
		this.jwtUtil = jwtUtil;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/login")
    public ResponseEntity<String> createAuthenticationToken(@RequestBody PatientDTO patientDTO) {
		
		 Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(patientDTO.getEmail(), patientDTO.getPassword()));

	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        
	        if(!userDetails.isEnabled()) {
	        	return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Your account is not verified");
	        }
	        
	        String role = userDetails.getAuthorities().stream()
	                .map(auth -> auth.getAuthority())
	                .findFirst()
	                .orElse("");
	        
	        String jwt = jwtUtil.generateToken(userDetails, role);

	        return ResponseEntity.ok(jwt);
    }
}