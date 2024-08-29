package com.healthconnection.application.usecase.healthprofessional.impl.rules.ruledomainvalidator;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.healthprofessional.impl.rules.RegisterHealthProfessionalRuleDomainValidator;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;
import com.healthconnection.domain.healthprofessional.rules.domain.HealthProfessionalEmailDoesNotExistRule;
import com.healthconnection.domain.healthprofessional.rules.domain.HealthProfessionalIdDoesNotExistRule;
import com.healthconnection.domain.healthprofessional.rules.domain.HealthProfessionalIdentificationDoesNotExistRule;

@Service
public class RegisterHealthProfessionalRuleDomainValidatorImpl implements RegisterHealthProfessionalRuleDomainValidator{

	private final HealthProfessionalIdDoesNotExistRule healthProfessionalIdDoesNotExistRule;
	private final HealthProfessionalIdentificationDoesNotExistRule healthProfessionalIdentificationDoesNotExistRule;
	private final HealthProfessionalEmailDoesNotExistRule  healthProfessionalEmailDoesNotExistRule;
	
	
	public RegisterHealthProfessionalRuleDomainValidatorImpl(
			HealthProfessionalIdDoesNotExistRule healthProfessionalIdDoesNotExistRule,
			HealthProfessionalIdentificationDoesNotExistRule healthProfessionalIdentificationDoesNotExistRule,
			HealthProfessionalEmailDoesNotExistRule healthProfessionalEmailDoesNotExistRule) {
		super();
		this.healthProfessionalIdDoesNotExistRule = healthProfessionalIdDoesNotExistRule;
		this.healthProfessionalIdentificationDoesNotExistRule = healthProfessionalIdentificationDoesNotExistRule;
		this.healthProfessionalEmailDoesNotExistRule = healthProfessionalEmailDoesNotExistRule;
	}



	@Override
	public void validate(HealthProfessionalDomain healthProfessionalDomain) {
		
		healthProfessionalIdDoesNotExistRule.execute(healthProfessionalDomain.getId());
		
		healthProfessionalIdentificationDoesNotExistRule.execute(healthProfessionalDomain.getIdentification());
		
		healthProfessionalEmailDoesNotExistRule.execute(healthProfessionalDomain.getEmail());
		
	}

}
