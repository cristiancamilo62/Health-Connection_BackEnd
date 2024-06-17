package com.healthconnection.application.usecase.notification;

import org.springframework.stereotype.Service;

@Service
public interface NotificationUseCase {
	
	void sendEmail(String email, String firstName);

}
