package com.healthconnection.infrastucture.adapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthconnection.application.usecase.verificationtoken.VerificationTokenUseCase;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;

@RestController
@RequestMapping("/verify-email")
public class VerificationController {

    private final VerificationTokenUseCase verificationTokenUseCase;

    public VerificationController(VerificationTokenUseCase verificationTokenUseCase) {
        this.verificationTokenUseCase = verificationTokenUseCase;
    }

    @GetMapping()
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
        if (TextHelper.isNull(token) || token.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token no proporcionado.");
        }

        boolean isVerified = verificationTokenUseCase.execute(token);

        if (isVerified) {
            return ResponseEntity.ok("Correo electrónico verificado exitosamente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al verificar el correo electrónico.");
        }
    }
}
