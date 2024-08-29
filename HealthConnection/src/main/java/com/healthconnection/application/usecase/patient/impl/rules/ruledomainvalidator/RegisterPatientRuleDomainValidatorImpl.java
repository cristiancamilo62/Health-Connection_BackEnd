package com.healthconnection.application.usecase.patient.impl.rules.ruledomainvalidator;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.patient.impl.rules.RegisterPatientRuleDomainValidator;
import com.healthconnection.domain.patient.PatientDomain;
import com.healthconnection.domain.patient.rules.domain.PatientEmailDoesNotExistRule;
import com.healthconnection.domain.patient.rules.domain.PatientIdDoesNotExistRule;
import com.healthconnection.domain.patient.rules.domain.PatientIdentificationDoesNotExistRule;

@Service
public class RegisterPatientRuleDomainValidatorImpl implements RegisterPatientRuleDomainValidator {

    private final PatientIdDoesNotExistRule patientIdDoesNotExistRule;
    private final PatientEmailDoesNotExistRule patientEmailDoesNotExistRule;
    private final PatientIdentificationDoesNotExistRule patientIdentificationDoesNotExistRule;

	public RegisterPatientRuleDomainValidatorImpl(PatientIdDoesNotExistRule patientIdDoesNotExistRule, 
			PatientEmailDoesNotExistRule patientEmailDoesNotExistRule,
			PatientIdentificationDoesNotExistRule patientIdentificationDoesNotExistRule) {
		this.patientIdDoesNotExistRule = patientIdDoesNotExistRule;
		this.patientEmailDoesNotExistRule = patientEmailDoesNotExistRule;
		this.patientIdentificationDoesNotExistRule = patientIdentificationDoesNotExistRule;
	}

    @Override
    public void validate(PatientDomain data) {
    	
        patientIdDoesNotExistRule.execute(data.getId());
        
        patientEmailDoesNotExistRule.execute(data.getEmail());
        
        patientIdentificationDoesNotExistRule.execute(data.getIdentification());
    }

}

