package com.healthconnection.domain.patient;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.affiliationregime.AffiliationRegimeDomain;
import com.healthconnection.domain.eps.EpsDomain;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;
import com.healthconnection.domain.role.RoleDomain;

@Service
public class PatientDomain {
	
	private UUID id;
	
	private String identification;

	private String firstName;

	private String middleName;

	private String lastName;

	private String middleLastName;

	private String email;

	private boolean confirmedEmail;
	
	private String phoneNumber;
	
	private boolean confirmedPhoneNumber;
	
	private String password;
	
	private String dateBirth;
	
	private IdentificationTypeDomain identificationType;

	private AffiliationRegimeDomain affiliationRegime;

	private EpsDomain eps;

	private boolean accountStatement;
	
	private RoleDomain role;
	
	
	public PatientDomain() {
		setId(UuidHelper.DEFAULT_UUID);
        setIdentification(TextHelper.EMPTY);
        setFirstName(TextHelper.EMPTY);
        setMiddleName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setMiddleLastName(TextHelper.EMPTY);
        setEmail(TextHelper.EMPTY);
        setConfirmedEmail(false);
        setPhoneNumber(TextHelper.EMPTY);
        setConfirmedPhoneNumber(false);
        setPassword(TextHelper.EMPTY);
        setDateBirth(TextHelper.EMPTY);
        setIdentificationType(new IdentificationTypeDomain());
        setAffiliationRegime(new AffiliationRegimeDomain());
        setEps(new EpsDomain());
        setAccountStatement(false);
        setRole(new RoleDomain());
	}
	
	


	public PatientDomain(UUID id, String identification, String firstName, String middleName, String lastName,
			String middleLastName, String email, boolean confirmedEmail, String phoneNumber,
			boolean confirmedPhoneNumber, String password, String dateBirth,
			IdentificationTypeDomain identificationType, AffiliationRegimeDomain affiliationRegime, EpsDomain eps,
			boolean accountStatement, RoleDomain role) {
		setId(id);
		setIdentification(identification);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setMiddleLastName(middleLastName);
		setEmail(email);
		setConfirmedEmail(confirmedEmail);
		setPhoneNumber(phoneNumber);
		setConfirmedPhoneNumber(confirmedPhoneNumber);
		setPassword(password);
		setDateBirth(dateBirth);
		setIdentificationType(identificationType);
		setAffiliationRegime(affiliationRegime);
		setEps(eps);
		setAccountStatement(accountStatement);
		setRole(role);
	}
	
	public final UUID getId() {
		return id;
	}

	public final String getIdentification() {
		return identification;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getMiddleName() {
		return middleName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getMiddleLastName() {
		return middleLastName;
	}
	public final RoleDomain getRole() {
		return role;
	}
	public final String getEmail() {
		return email;
	}
	public final boolean isConfirmedEmail() {
		return confirmedEmail;
	}
	public final String getPhoneNumber() {
		return phoneNumber;
	}
	public final boolean isConfirmedPhoneNumber() {
		return confirmedPhoneNumber;
	}
	public final String getPassword() {
		return password;
	}

	public final String getDateBirth() {
		return dateBirth;
	}

	public final IdentificationTypeDomain getIdentificationType() {
		return identificationType;
	}

	public final AffiliationRegimeDomain getAffiliationRegime() {
		return affiliationRegime;
	}

	public final EpsDomain getEps() {
		return eps;
	}

	public final boolean isAccountStatement() {
		return accountStatement;
	}


	public final void setId(UUID id) {
		this.id = id;
	}

	public final void setIdentification(String identification) {
		this.identification = ObjectHelper.getDefault(TextHelper.applyTrim(identification), TextHelper.EMPTY);
	}

	public final void setFirstName(String firstName) {
		this.firstName = ObjectHelper.getDefault(TextHelper.applyTrim(firstName), TextHelper.EMPTY);
	}

	public final void setMiddleName(String middleName) {
		this.middleName = ObjectHelper.getDefault(TextHelper.applyTrim(middleName), TextHelper.EMPTY);
	}

	public final void setLastName(String lastName) {
		this.lastName = ObjectHelper.getDefault(TextHelper.applyTrim(lastName), TextHelper.EMPTY);
	}

	public final void setMiddleLastName(String middleLastName) {
		this.middleLastName = ObjectHelper.getDefault(TextHelper.applyTrim(middleLastName), TextHelper.EMPTY);
	}

	public final void setDateBirth(String dateBirth) {
		this.dateBirth = ObjectHelper.getDefault(TextHelper.applyTrim(dateBirth), TextHelper.EMPTY);
	}
	

	public final void setEmail(String email) {
		this.email = ObjectHelper.getDefault(TextHelper.applyTrim(email), TextHelper.EMPTY);
	}

	public final void setConfirmedEmail(boolean confirmedEmail) {
		this.confirmedEmail = ObjectHelper.getDefault(confirmedEmail, false);
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = ObjectHelper.getDefault(TextHelper.applyTrim(phoneNumber), TextHelper.EMPTY);
	}

	public final void setConfirmedPhoneNumber(boolean confirmedPhoneNumber) {
		this.confirmedPhoneNumber = ObjectHelper.getDefault(confirmedPhoneNumber, false);
	}

	public final void setPassword(String password) {
		this.password = ObjectHelper.getDefault(TextHelper.applyTrim(password), TextHelper.EMPTY);
	}

	public final void setIdentificationType(IdentificationTypeDomain identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, new IdentificationTypeDomain());
	}

	public final void setAffiliationRegime(AffiliationRegimeDomain affiliationRegime) {
		this.affiliationRegime = ObjectHelper.getDefault(affiliationRegime, new AffiliationRegimeDomain());
	}

	public final void setEps(EpsDomain eps) {
		this.eps = ObjectHelper.getDefault(eps, new EpsDomain());
	}

	public final void setAccountStatement(boolean accountStatement) {
		this.accountStatement = ObjectHelper.getDefault(accountStatement, false);
	}

	public final void setRole(RoleDomain role) {
		this.role = ObjectHelper.getDefault(role, new RoleDomain());
	}
	
}
