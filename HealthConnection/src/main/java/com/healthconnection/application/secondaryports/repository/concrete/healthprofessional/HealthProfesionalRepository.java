package com.healthconnection.application.secondaryports.repository.concrete.healthprofessional;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthconnection.application.secondaryports.entity.HealthProfessionalEntity;


public interface HealthProfesionalRepository extends JpaRepository<HealthProfessionalEntity, UUID>{

}
