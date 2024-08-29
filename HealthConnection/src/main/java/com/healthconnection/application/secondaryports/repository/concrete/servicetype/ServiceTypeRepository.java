package com.healthconnection.application.secondaryports.repository.concrete.servicetype;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthconnection.application.secondaryports.entity.ServiceTypeEntity;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, UUID>{

}
