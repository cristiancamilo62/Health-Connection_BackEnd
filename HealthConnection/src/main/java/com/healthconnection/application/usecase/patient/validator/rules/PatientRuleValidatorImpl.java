package com.healthconnection.application.usecase.patient.validator.rules;


import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.exceptions.NullPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.domain.patient.PatientDomain;
import com.healthconnection.domain.patient.rules.validators.PatientRuleValidator;

@Service
public class PatientRuleValidatorImpl implements PatientRuleValidator{


	@Override
	public final void execute(final PatientDomain patientDomain) {
		if(ObjectHelper.isNull(patientDomain)) {
			throw new NullPatientRuleValidatorException();
		}
		
	}

}
