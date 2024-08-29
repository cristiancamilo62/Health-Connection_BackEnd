package com.healthconnection.application.usecase.patient.validator.rules;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.patient.exceptions.EmptyDateBirthPatientRuleValidatorException;
import com.healthconnection.application.usecase.patient.exceptions.InvalidFormatDateBirthPatientRuleValidatorException;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.domain.patient.rules.validators.DateBirthPatientRuleValidator;

@Service
public class DateBirthPatientRuleValidatorImpl implements DateBirthPatientRuleValidator{

	@Override
	public final void execute(final String dateBirth) {
		
		validateAbligatory(dateBirth);
		validateFormat(dateBirth);
		
	}
	
	private final void validateAbligatory(final String dateBirth) {
		if(TextHelper.isEmpty(dateBirth)) {
			throw new EmptyDateBirthPatientRuleValidatorException();
		}
	}
	
	private final void validateFormat(final String dateBirth) {
		if(!TextHelper.isValidDateTime(dateBirth)) {
			throw new InvalidFormatDateBirthPatientRuleValidatorException();
		}
	}
	
	//TODO: VALIDAR QUE SEA ANTES QUE LA FECHA ACTUAL EN DOMAIN Y VALIDAR TMABIEN QUE LA CEDULA AÑO CON TIPO DE DOCUMENTO

}
