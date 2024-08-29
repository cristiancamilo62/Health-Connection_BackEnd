package com.healthconnection.application.usecase.notification.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.notification.NotificationUseCase;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class NotificationUseCaseImpl implements NotificationUseCase {

    private static final Logger logger = LoggerFactory.getLogger(NotificationUseCaseImpl.class);

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    @Value("${notification.email.sender}")
    private String senderEmail;

    @Value("${app.url}")
    private String appUrl; // La URL base de tu aplicación

    @Override
    public void sendEmail(String recipientEmail, String token) {
        Email from = new Email(senderEmail);
        String subject = "Verifica tu dirección de correo electrónico";
        Email to = new Email(recipientEmail);

        // Construir el enlace de verificación con el token
        String verificationUrl = String.format("%s/verify-email?token=%s", appUrl, token);

        // Contenido del correo electrónico
        String emailContent = String.format(
            "Hola,\n\n" +
            "Gracias por registrarte en HealthConnection. Para completar tu registro, por favor verifica tu dirección de correo electrónico haciendo clic en el siguiente enlace:\n\n" +
            "%s\n\n" +
            "Si no has solicitado este registro, por favor ignora este correo. \n\n" +
            "Saludos cordiales,\n" +
            "El equipo de HealthConnection",
            verificationUrl
        );

        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            // Enviar la solicitud
            sg.api(request);

            logger.info("Verification email sent successfully to {}", recipientEmail);
        } catch (Exception ex) {
            logger.error("Error sending verification email: ", ex);
        }
    }
}

