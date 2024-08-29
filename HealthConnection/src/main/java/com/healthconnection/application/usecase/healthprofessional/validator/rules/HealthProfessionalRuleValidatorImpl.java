package com.healthconnection.application.usecase.healthprofessional.validator.rules;


import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.exceptions.NullPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;
import com.healthconnection.domain.healthprofessional.rules.validators.HealthProfessionalRuleValidator;

@Service
public class HealthProfessionalRuleValidatorImpl implements HealthProfessionalRuleValidator{


	@Override
	public final void execute(final HealthProfessionalDomain healthProfessionalDomain ) {
		if(ObjectHelper.isNull(healthProfessionalDomain)) {
			throw new NullPatientRuleValidatorException();
		}
		
	}

}
