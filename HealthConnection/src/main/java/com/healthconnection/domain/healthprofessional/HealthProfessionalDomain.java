package com.healthconnection.domain.healthprofessional;

import java.sql.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.helper.DateHelper;
import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import com.healthconnection.domain.identificationtype.IdentificationTypeDomain;
import com.healthconnection.domain.role.RoleDomain;
import com.healthconnection.domain.servicetype.ServiceTypeDomain;

@Service
public class HealthProfessionalDomain {

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
    private Date dateBirth;
    private Date startDate;
	private ServiceTypeDomain serviceType;
	private IdentificationTypeDomain identificationType;
	private RoleDomain role;
	private boolean accountStatement;
	private String profilePictureUrl;
	
	

	public HealthProfessionalDomain() {
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
        setDateBirth(new Date(0));
        setStartDate(new Date(0));
		setServiceType(new ServiceTypeDomain());
		setIdentificationType(new IdentificationTypeDomain());
		setRole(new RoleDomain());
		setAccountStatement(false);
		setProfilePictureUrl(TextHelper.EMPTY);
	}
	
	public HealthProfessionalDomain(UUID id, String identification, String firstName, String middleName,
			String lastName, String middleLastName, String email, boolean confirmedEmail,
			String phoneNumber, boolean confirmedPhoneNumber, String password, Date dateBirth, Date startDate,
			ServiceTypeDomain serviceType, IdentificationTypeDomain identificationType, RoleDomain role,
			String profilePictureUrl, boolean accountStatement) {
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
		setStartDate(startDate);
		setServiceType(serviceType);
		setIdentificationType(identificationType);
		setRole(role);
		setAccountStatement(accountStatement);
		setProfilePictureUrl(profilePictureUrl);
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = ObjectHelper.getDefault(TextHelper.applyTrim(identification), TextHelper.EMPTY);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = ObjectHelper.getDefault(TextHelper.applyTrim(firstName), TextHelper.EMPTY);
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = ObjectHelper.getDefault(TextHelper.applyTrim(middleName), TextHelper.EMPTY);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = ObjectHelper.getDefault(TextHelper.applyTrim(lastName), TextHelper.EMPTY);
	}

	public String getMiddleLastName() {
		return middleLastName;
	}

	public void setMiddleLastName(String middleLastName) {
		this.middleLastName = ObjectHelper.getDefault(TextHelper.applyTrim(middleLastName), TextHelper.EMPTY);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = ObjectHelper.getDefault(TextHelper.applyTrim(email), TextHelper.EMPTY);
	}

	public boolean isConfirmedEmail() {
		return confirmedEmail;
	}

	public void setConfirmedEmail(boolean confirmedEmail) {
		this.confirmedEmail = ObjectHelper.getDefault(confirmedEmail, false);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = ObjectHelper.getDefault(TextHelper.applyTrim(phoneNumber), TextHelper.EMPTY);
	}

	public boolean isConfirmedPhoneNumber() {
		return confirmedPhoneNumber;
	}

	public void setConfirmedPhoneNumber(boolean confirmedPhoneNumber) {
		this.confirmedPhoneNumber = ObjectHelper.getDefault(confirmedPhoneNumber, false);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = ObjectHelper.getDefault(TextHelper.applyTrim(password), TextHelper.EMPTY);
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public final Date getStartDate() {
		return startDate;
	}

	public final void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public ServiceTypeDomain getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceTypeDomain serviceType) {
		this.serviceType = ObjectHelper.getDefault(serviceType, new ServiceTypeDomain());
	}

	public IdentificationTypeDomain getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(IdentificationTypeDomain identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, new IdentificationTypeDomain());
	}

	public RoleDomain getRole() {
		return role;
	}

	public void setRole(RoleDomain role) {
		this.role = ObjectHelper.getDefault(role, new RoleDomain());
	}

	public boolean isAccountStatement() {
		return accountStatement;
	}

	public void setAccountStatement(boolean accountStatement) {
		this.accountStatement = ObjectHelper.getDefault(accountStatement, false);
	}

	public final String getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public final void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = ObjectHelper.getDefault(TextHelper.applyTrim(profilePictureUrl), TextHelper.EMPTY);
	}
	
}

