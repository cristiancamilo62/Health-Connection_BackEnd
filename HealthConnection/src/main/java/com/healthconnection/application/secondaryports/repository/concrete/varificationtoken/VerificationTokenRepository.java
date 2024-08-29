package com.healthconnection.application.secondaryports.repository.concrete.varificationtoken;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthconnection.application.secondaryports.entity.VerificationTokenEntity;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Long> {
	
	Optional<VerificationTokenEntity> findByToken(String token);

}
