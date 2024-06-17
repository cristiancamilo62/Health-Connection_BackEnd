package com.healthconnection.application.secondaryports.repository.concrete.appointment;

import java.sql.Date;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthconnection.application.secondaryports.entity.AppointmentEntity;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, UUID>{
	
	boolean existsByStartDateAndEndDateAndHealthProfessional(
            Date startDate, Date endDate, HealthProfessionalEntity healthProfessional);
	
	boolean existsByStartDateAndEndDateAndAppointmentServiceDataClinic(Date startDate, Date endDate, String clinic);

}
