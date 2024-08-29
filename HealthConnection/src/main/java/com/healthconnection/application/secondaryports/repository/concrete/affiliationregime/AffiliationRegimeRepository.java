package com.healthconnection.application.secondaryports.repository.concrete.affiliationregime;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthconnection.application.secondaryports.entity.AffiliationRegimeEntity;

@Repository
public interface AffiliationRegimeRepository extends JpaRepository<AffiliationRegimeEntity, UUID>{

}
