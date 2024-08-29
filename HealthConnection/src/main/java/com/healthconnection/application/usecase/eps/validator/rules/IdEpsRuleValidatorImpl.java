package com.healthconnection.application.usecase.eps.validator.rules;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.eps.exceptions.DefaultIdEpsRuleValidatorException;
import com.healthconnection.application.usecase.eps.exceptions.NullIdEpsRuleValidatorException;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.eps.rules.validators.IdEpsRuleValidator;

@Service
public class IdEpsRuleValidatorImpl implements IdEpsRuleValidator{

	@Override
	public final void execute(final UUID data) {
		validateIdNull(data);
		validateIdDefault(data);
		
	}
	
	private final void validateIdDefault(final UUID id) {
		if(UuidHelper.isDefault(id)) {
			throw new DefaultIdEpsRuleValidatorException();
		}
	}
	
	private final void validateIdNull(final UUID id) {
		if(UuidHelper.isUuidNull(id)) {
			throw new NullIdEpsRuleValidatorException();
		}
	}

}
