package com.healthconnection.application.usecase.affiliationregime.validator.rules;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.affiliationregime.exceptions.DefaultIdAffiliationRegimeRuleValidatorException;
import com.healthconnection.application.usecase.affiliationregime.exceptions.NullIdAffiliationRegimeRuleValidatorException;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.affiliationregime.rules.validators.IdAffiliationRegimeRuleValidator;

@Service
public class IdAffiliationRegimeRuleValidatorImpl implements IdAffiliationRegimeRuleValidator{

	
	@Override
	public final void execute(final UUID data) {
		validateIdNull(data);
		validateIdDefault(data);
		
	}
	
	private final void validateIdDefault(final UUID id) {
		if(UuidHelper.isDefault(id)) {
			throw new DefaultIdAffiliationRegimeRuleValidatorException();
		}
	}
	
	private final void validateIdNull(final UUID id) {
		if(UuidHelper.isUuidNull(id)) {
			throw new NullIdAffiliationRegimeRuleValidatorException();
		}
	}

}
