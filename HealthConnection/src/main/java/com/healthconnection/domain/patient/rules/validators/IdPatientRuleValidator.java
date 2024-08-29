package com.healthconnection.domain.patient.rules.validators;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.domain.Rule;

@Service
public interface IdPatientRuleValidator extends Rule<UUID>{

}
