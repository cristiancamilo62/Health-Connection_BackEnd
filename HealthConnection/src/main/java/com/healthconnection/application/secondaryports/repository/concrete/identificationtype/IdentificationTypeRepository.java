package com.healthconnection.application.secondaryports.repository.concrete.identificationtype;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;


@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationTypeEntity, UUID>{
	
	IdentificationTypeEntity findByCode(String code);

}
