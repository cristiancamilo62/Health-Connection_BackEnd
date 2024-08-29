package com.healthconnection.application.usecase.healthprofessional.validator.impl;

import org.springframework.stereotype.Service;
import com.healthconnection.application.usecase.healthprofessional.validator.RegisterHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.HealthProfessionalDomain;
import com.healthconnection.domain.healthprofessional.rules.validators.DateBirthHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.EmailHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.HealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.IdHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.IdentificationHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.NameHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.PasswordHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.PhoneNumberHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.ProfilePictureUrlHealthProfessionalRuleValidator;
import com.healthconnection.domain.healthprofessional.rules.validators.StartDateHealthProfessionalRulevalidator;
import com.healthconnection.domain.identificationtype.rules.validators.IdIdentificationTypeRuleValidator;

@Service
public class RegisterHealthProfessionalRuleValidatorImpl implements RegisterHealthProfessionalRuleValidator{
	
	private final HealthProfessionalRuleValidator healthProfessionalRuleValidator;
	private final IdHealthProfessionalRuleValidator idHealthProfessionalRuleValidator;
	private final IdentificationHealthProfessionalRuleValidator identificationHealthProfessionalRuleValidator;
	private final NameHealthProfessionalRuleValidator nameHealthProfessionalRuleValidator;
	private final EmailHealthProfessionalRuleValidator emailHealthProfessionalRuleValidator;
	private final PhoneNumberHealthProfessionalRuleValidator phoneNumberHealthProfessionalRuleValidator;
	private final PasswordHealthProfessionalRuleValidator passwordHealthProfessionalRuleValidator;
	private final DateBirthHealthProfessionalRuleValidator dateBirthHealthProfessionalRuleValidator;
	private final IdIdentificationTypeRuleValidator idIdentificationTypeRuleValidator;
	private final ProfilePictureUrlHealthProfessionalRuleValidator profilePictureUrlHealthProfessionalRuleValidator;
	private final StartDateHealthProfessionalRulevalidator startDateHealthProfessionalRulevalidator;
	

	public RegisterHealthProfessionalRuleValidatorImpl(HealthProfessionalRuleValidator healthProfessionalRuleValidator,
			IdHealthProfessionalRuleValidator idHealthProfessionalRuleValidator,
			IdentificationHealthProfessionalRuleValidator identificationHealthProfessionalRuleValidator,
			NameHealthProfessionalRuleValidator nameHealthProfessionalRuleValidator,
			EmailHealthProfessionalRuleValidator emailHealthProfessionalRuleValidator,
			PhoneNumberHealthProfessionalRuleValidator phoneNumberHealthProfessionalRuleValidator,
			PasswordHealthProfessionalRuleValidator passwordHealthProfessionalRuleValidator,
			DateBirthHealthProfessionalRuleValidator dateBirthHealthProfessionalRuleValidator,
			IdIdentificationTypeRuleValidator idIdentificationTypeRuleValidator,
			ProfilePictureUrlHealthProfessionalRuleValidator profilePictureUrlHealthProfessionalRuleValidator,
			StartDateHealthProfessionalRulevalidator startDateHealthProfessionalRulevalidator) {
		super();
		this.healthProfessionalRuleValidator = healthProfessionalRuleValidator;
		this.idHealthProfessionalRuleValidator = idHealthProfessionalRuleValidator;
		this.identificationHealthProfessionalRuleValidator = identificationHealthProfessionalRuleValidator;
		this.nameHealthProfessionalRuleValidator = nameHealthProfessionalRuleValidator;
		this.emailHealthProfessionalRuleValidator = emailHealthProfessionalRuleValidator;
		this.phoneNumberHealthProfessionalRuleValidator = phoneNumberHealthProfessionalRuleValidator;
		this.passwordHealthProfessionalRuleValidator = passwordHealthProfessionalRuleValidator;
		this.dateBirthHealthProfessionalRuleValidator = dateBirthHealthProfessionalRuleValidator;
		this.idIdentificationTypeRuleValidator = idIdentificationTypeRuleValidator;
		this.profilePictureUrlHealthProfessionalRuleValidator = profilePictureUrlHealthProfessionalRuleValidator;
		this.startDateHealthProfessionalRulevalidator = startDateHealthProfessionalRulevalidator;
	}


	@Override
	public void validate(HealthProfessionalDomain healthProfessionalDomain) {
		
		healthProfessionalRuleValidator.execute(healthProfessionalDomain);
		
		idHealthProfessionalRuleValidator.execute(healthProfessionalDomain.getId());
		
		identificationHealthProfessionalRuleValidator.execute(healthProfessionalDomain.getIdentification());
		
		nameHealthProfessionalRuleValidator.execute(healthProfessionalDomain);
		
		emailHealthProfessionalRuleValidator.execute(healthProfessionalDomain.getEmail());
		
		phoneNumberHealthProfessionalRuleValidator.execute(healthProfessionalDomain.getPhoneNumber());
		
		passwordHealthProfessionalRuleValidator.execute(healthProfessionalDomain.getPassword());
		
		dateBirthHealthProfessionalRuleValidator.execute(healthProfessionalDomain.getDateBirth());
		
		idIdentificationTypeRuleValidator.execute(healthProfessionalDomain.getIdentificationType().getId());
		
		profilePictureUrlHealthProfessionalRuleValidator.execute(healthProfessionalDomain.getProfilePictureUrl());
		
		startDateHealthProfessionalRulevalidator.execute(healthProfessionalDomain.getStartDate());
	}

}
