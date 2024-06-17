package com.healthconnection.application.usecase.patient.impl.rules.rulevalidator;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.patient.impl.rules.RegisterPatientRuleValidator;
import com.healthconnection.domain.patient.PatientDomain;
import com.healthconnection.domain.patient.rules.PatientEmailDoesNotExistRule;
import com.healthconnection.domain.patient.rules.PatientIdDoesNotExistRule;
import com.healthconnection.domain.patient.rules.PatientIdentificationDoesNotExistRule;

@Service
public class RegisterPatientRuleValidatorImpl implements RegisterPatientRuleValidator {

    private final PatientIdDoesNotExistRule patientIdDoesNotExistRule;
    private final PatientEmailDoesNotExistRule patientEmailDoesNotExistRule;
    private final PatientIdentificationDoesNotExistRule patientIdentificationDoesNotExistRule;

	public RegisterPatientRuleValidatorImpl(PatientIdDoesNotExistRule patientIdDoesNotExistRule, 
			PatientEmailDoesNotExistRule patientEmailDoesNotExistRule,
			PatientIdentificationDoesNotExistRule patientIdentificationDoesNotExistRule) {
		super();
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

