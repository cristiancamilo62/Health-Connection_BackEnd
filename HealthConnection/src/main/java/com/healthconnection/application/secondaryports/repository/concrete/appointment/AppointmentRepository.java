package com.healthconnection.application.secondaryports.repository.concrete.appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID>{
	
	boolean existsByStartDateAndEndDateAndHealthProfessional(
            LocalDateTime startDate, LocalDateTime endDate, HealthProfessionalEntity healthProfessional);
	
	boolean existsByStartDateAndEndDateAndAppointmentServiceDataClinic(LocalDateTime startDate,
			LocalDateTime endDate, String clinic);
	
	List<AppointmentEntity> findByHealthProfessionalIdAndStartDateBetween(UUID healthProfessionalId, LocalDateTime startDate, LocalDateTime endDate);

}
