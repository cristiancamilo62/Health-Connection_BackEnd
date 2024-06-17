package com.healthconnection.application.secondaryports.repository.concrete.patient;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthconnection.application.secondaryports.entity.PatientEntity;
import com.healthconnection.application.secondaryports.entity.RoleEntity;


@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {
	
	List<PatientEntity> findByIdentification(String identification);
	
	
	boolean existsByEmail(String email);
	
	boolean existsByEmailAndPassword(String user, String password);
	

}

