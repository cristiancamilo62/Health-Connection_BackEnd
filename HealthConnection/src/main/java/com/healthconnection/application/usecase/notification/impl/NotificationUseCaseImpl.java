package com.healthconnection.application.usecase.notification.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.notification.NotificationUseCase;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificationUseCaseImpl implements NotificationUseCase {

    private static final Logger logger = LoggerFactory.getLogger(NotificationUseCaseImpl.class);

    @Value("${sendgrid.api-key}")
    private String sendGridApiKey;
    
    @Value("${notification.email.sender}")
    private String senderEmail;

    @Override
    public void sendEmail(String addressee, String firstName) {

        Email from = new Email(senderEmail);
        String subject = "Bienvenido a HealthConnection";
        Email to = new Email(addressee);

        String emailContent = """
            Hola %s,

            ¡Bienvenido a HealthConnection! Nos alegra mucho que te hayas unido a nuestra comunidad.

            Tu registro ha sido exitoso y ahora tienes acceso a una plataforma que te ayudará a gestionar tu salud de manera más efectiva. Aquí podrás encontrar recursos, conectarte con profesionales de la salud y mantener un seguimiento de tu bienestar.

            Para empezar, te recomendamos que explores las siguientes funcionalidades:

            - Consultas Médicas: Programa y gestiona tus citas médicas.
            - Pagos en línea: Paga tus citas médicas desde la plataforma.

            Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos a través de nuestro soporte al cliente.

            Gracias por confiar en nosotros para cuidar de tu salud.

            Saludos cordiales,

            El equipo de HealthConnection
            """.formatted(firstName);

        Content content = new Content("text/plain", emailContent);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            sg.api(request);
        } catch (Exception ex) {
            logger.error("Error sending email: ", ex);
        }
    }
}
