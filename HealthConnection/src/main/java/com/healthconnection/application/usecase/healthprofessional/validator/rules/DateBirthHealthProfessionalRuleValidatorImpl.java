package com.healthconnection.application.usecase.healthprofessional.validator.rules;

import java.sql.Date;

import org.springframework.stereotype.Service;
import com.healthconnection.domain.healthprofessional.rules.validators.DateBirthHealthProfessionalRuleValidator;

@Service
public class DateBirthHealthProfessionalRuleValidatorImpl implements DateBirthHealthProfessionalRuleValidator{

	@Override
	public final void execute(final Date dateBirth) {
		
		//TODO: validateAbligatory(dateBirth);
		//validateFormat(dateBirth);
		
	}
	
	/*private final void validateAbligatory(final Date dateBirth) {
		if(TextHelper.isEmpty(dateBirth)) {
			throw new EmptyDateBirthPatientRuleValidatorException();
		}
	}
	
	private final void validateFormat(final Date dateBirth) {
		if(!TextHelper.isValidDateTime(dateBirth)) {
			throw new InvalidFormatDateBirthPatientRuleValidatorException();
		}
	}*/
	
	//TODO: VALIDAR QUE SEA ANTES QUE LA FECHA ACTUAL EN DOMAIN Y VALIDAR TMABIEN QUE LA CEDULA AÑO CON TIPO DE DOCUMENTO

}
