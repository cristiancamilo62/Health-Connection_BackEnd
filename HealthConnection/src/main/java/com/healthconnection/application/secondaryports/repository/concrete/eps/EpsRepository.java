package com.healthconnection.application.secondaryports.repository.concrete.eps;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.healthconnection.application.secondaryports.entity.EpsEntity;


@Repository
public interface EpsRepository extends JpaRepository<EpsEntity, UUID>{

}
