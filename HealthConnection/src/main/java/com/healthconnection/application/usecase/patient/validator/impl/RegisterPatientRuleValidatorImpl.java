package com.healthconnection.application.usecase.patient.validator.impl;

import org.springframework.stereotype.Service;

import com.healthconnection.application.usecase.patient.validator.RegisterPatientRuleValidator;
import com.healthconnection.domain.affiliationregime.rules.validators.IdAffiliationRegimeRuleValidator;
import com.healthconnection.domain.eps.rules.validators.IdEpsRuleValidator;
import com.healthconnection.domain.identificationtype.rules.validators.IdIdentificationTypeRuleValidator;
import com.healthconnection.domain.patient.PatientDomain;
import com.healthconnection.domain.patient.rules.validators.DateBirthPatientRuleValidator;
import com.healthconnection.domain.patient.rules.validators.EmailPatientRuleValidator;
import com.healthconnection.domain.patient.rules.validators.IdPatientRuleValidator;
import com.healthconnection.domain.patient.rules.validators.IdentificationPatientRuleValidator;
import com.healthconnection.domain.patient.rules.validators.NamePatientRuleValidator;
import com.healthconnection.domain.patient.rules.validators.PasswordPatientRuleValidator;
import com.healthconnection.domain.patient.rules.validators.PatientRuleValidator;
import com.healthconnection.domain.patient.rules.validators.PhoneNumberPatientRuleValidator;

@Service
public class RegisterPatientRuleValidatorImpl implements RegisterPatientRuleValidator{

	private final PatientRuleValidator patientRuleValidator;
	private final IdPatientRuleValidator idPatientRuleValidator;
	private final IdentificationPatientRuleValidator identificationPatientRuleValidator;
	private final NamePatientRuleValidator namePatientRuleValidator;
	private final EmailPatientRuleValidator emailPatientRuleValidator;
	private final PhoneNumberPatientRuleValidator phoneNumberPatientRuleValidator;
	private final PasswordPatientRuleValidator passwordPatientRuleValidator;
	private final DateBirthPatientRuleValidator dateBirthPatientRuleValidator;
	private final IdIdentificationTypeRuleValidator idIdentificationTypeRuleValidator;
	private final IdEpsRuleValidator idEpsRuleValidator;
	private final IdAffiliationRegimeRuleValidator idAffiliationRegimeRuleValidator;
	

	public RegisterPatientRuleValidatorImpl(PatientRuleValidator patientRuleValidator,
			IdPatientRuleValidator idPatientRuleValidator,
			IdentificationPatientRuleValidator identificationPatientRuleValidator,
			NamePatientRuleValidator namePatientRuleValidator, EmailPatientRuleValidator emailPatientRuleValidator,
			PhoneNumberPatientRuleValidator phoneNumberPatientRuleValidator,
			PasswordPatientRuleValidator passwordPatientRuleValidator,
			DateBirthPatientRuleValidator dateBirthPatientRuleValidator,
			IdIdentificationTypeRuleValidator idIdentificationTypeRuleValidator, IdEpsRuleValidator idEpsRuleValidator,
			IdAffiliationRegimeRuleValidator idAffiliationRegimeRuleValidator) {
		super();
		this.patientRuleValidator = patientRuleValidator;
		this.idPatientRuleValidator = idPatientRuleValidator;
		this.identificationPatientRuleValidator = identificationPatientRuleValidator;
		this.namePatientRuleValidator = namePatientRuleValidator;
		this.emailPatientRuleValidator = emailPatientRuleValidator;
		this.phoneNumberPatientRuleValidator = phoneNumberPatientRuleValidator;
		this.passwordPatientRuleValidator = passwordPatientRuleValidator;
		this.dateBirthPatientRuleValidator = dateBirthPatientRuleValidator;
		this.idIdentificationTypeRuleValidator = idIdentificationTypeRuleValidator;
		this.idEpsRuleValidator = idEpsRuleValidator;
		this.idAffiliationRegimeRuleValidator = idAffiliationRegimeRuleValidator;
	}


	@Override
	public void validate(PatientDomain patientDomain) {
		
		patientRuleValidator.execute(patientDomain);
		
		idPatientRuleValidator.execute(patientDomain.getId());
		
		namePatientRuleValidator.execute(patientDomain);
		
		idIdentificationTypeRuleValidator.execute(patientDomain.getIdentificationType().getId());
		
		identificationPatientRuleValidator.execute(patientDomain.getIdentification());
		
		emailPatientRuleValidator.execute(patientDomain.getEmail());
		
		passwordPatientRuleValidator.execute(patientDomain.getPassword());
		
		dateBirthPatientRuleValidator.execute(patientDomain.getDateBirth());
		
		phoneNumberPatientRuleValidator.execute(patientDomain.getPhoneNumber());
		
		idEpsRuleValidator.execute(patientDomain.getEps().getId());
		
		idAffiliationRegimeRuleValidator.execute(patientDomain.getAffiliationRegime().getId());
		
		
	}

}
