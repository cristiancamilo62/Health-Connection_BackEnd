package com.healthconnection.application.usecase.verificationtoken;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.UseCaseWithReturn;

@Service
public interface VerificationTokenUseCase extends UseCaseWithReturn<String, Boolean> {

}
