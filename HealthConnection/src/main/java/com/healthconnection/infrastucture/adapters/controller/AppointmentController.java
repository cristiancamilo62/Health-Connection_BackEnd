package com.healthconnection.infrastucture.adapters.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthconnection.application.primaryports.dto.AppointmentDTO;
import com.healthconnection.application.primaryports.interactor.appointment.ConsultAppointmentInteractor;
import com.healthconnection.application.primaryports.interactor.appointment.RegisterAppointmentInteractor;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.crosscutting.exception.HealthException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.messages.MessageCatalog;
import com.healthconnection.crosscutting.messages.enums.MessageCode;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
	
	private final RegisterAppointmentInteractor registerAppointmentInteractor;
	private final ConsultAppointmentInteractor consultAppointmentInteractor;

	
	public AppointmentController(RegisterAppointmentInteractor registerAppointmentInteractor,
			ConsultAppointmentInteractor consultAppointmentInteractor) {
		super();
		this.registerAppointmentInteractor = registerAppointmentInteractor;
		this.consultAppointmentInteractor = consultAppointmentInteractor;
	}

	@GetMapping("dummy")
	public AppointmentDTO obtener() {
		logger.info("obteniendo dummy");
		return new AppointmentDTO();
	}
	
	@PostMapping
    public ResponseEntity<String> register(@RequestBody AppointmentDTO appointmentDTO) {
        
		if (ObjectHelper.isNull(appointmentDTO)) {
            logger.error("Solicitud de registro de cita con datos nulos");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar cita nula");
        }

        logger.info("Registrando nueva cita con id: {}", appointmentDTO.getId());

        try {
            registerAppointmentInteractor.execute(appointmentDTO);
            logger.info("Cita registrado exitosamente: {}", appointmentDTO.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(MessageCatalog.getContentMessage(MessageCode.M0000012));
        } catch (final HealthException exception) {
            logger.error("error al registrar cita A: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar cita : "+ exception.getMessage());
        }catch (final Exception exception) {
            logger.error("Error al registrar cita B: {}", exception.getMessage(), exception);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar cita. Por favor intente de nuevo");
        }
    }
	@PostMapping("/consultar")
	public ResponseEntity<List<AppointmentEntity>> getAppointments(@RequestBody AppointmentDTO appointmentDTO) {


	    List<AppointmentEntity> appointments = consultAppointmentInteractor.execute(appointmentDTO);
	    
	    return ResponseEntity.ok(appointments);
	}


}
