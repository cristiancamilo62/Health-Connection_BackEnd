package com.healthconnection.application.secondaryports.repository.concrete.healthprofessional;

import java.util.UUID;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;

@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthProfessionalEntity, UUID>{
	
	boolean existsByEmail(String email);
	
	List<HealthProfessionalEntity> findByIdentification(String identification);
	
	Optional<HealthProfessionalEntity> findByEmail(String email);

}
