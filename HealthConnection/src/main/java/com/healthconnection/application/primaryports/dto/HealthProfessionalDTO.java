package com.healthconnection.application.primaryports.dto;

import java.sql.Date;
import java.util.UUID;
import org.springframework.stereotype.Component;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@AllArgsConstructor
public class HealthProfessionalDTO {

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
	private ServiceTypeDTO serviceType;
	private IdentificationTypeDTO identificationType;
	private RoleDTO role;
	private boolean accountStatement;
	private String profilePictureUrl;
	
	public HealthProfessionalDTO() {
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
		setServiceType(new ServiceTypeDTO());
		setIdentificationType(new IdentificationTypeDTO());
		setRole(new RoleDTO());
		setAccountStatement(false);
		setProfilePictureUrl(TextHelper.EMPTY);
	}
	
}
