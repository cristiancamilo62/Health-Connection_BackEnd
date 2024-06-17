package com.healthconnection.application.secondaryports.repository.concrete.identificationtype;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthconnection.application.secondaryports.entity.IdentificationTypeEntity;

public interface IdentificationTypeRepository extends JpaRepository<IdentificationTypeEntity, UUID>{

}
