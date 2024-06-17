package com.healthconnection.application.primaryports.dto;

import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@AllArgsConstructor
@Getter @Setter
@Validated
public class PatientDTO {
    
    @NotNull(message = "ID cannot be null")
    private UUID id;  
    
    @NotNull(message = "Identification cannot be null")
    @NotEmpty(message = "Identification cannot be empty")
    @Size(min = 10, max = 10, message = "Identification must be exactly 10 digits")
    @Pattern(regexp = "^\\d+$", message = "Identification must contain only digits")
    private String identification;
    
    @NotNull(message = "First name cannot be null")
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    private String firstName;
    
    @NotNull(message = "Middle name cannot be null")
    @NotEmpty(message = "Middle name cannot be empty")
    @Size(min = 2, max = 20, message = "Middle name must be between 2 and 20 characters")
    private String middleName;
    
    @NotNull(message = "Last name cannot be null")
    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    private String lastName;
    
    @NotNull(message = "Middle last name cannot be null")
    @NotEmpty(message = "Middle last name cannot be empty")
    @Size(min = 2, max = 20, message = "Middle last name must be between 2 and 20 characters")
    private String middleLastName;
    
    @Size(min = 8, max = 25, message = "Email must be between 8 and 25 characters")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Confirmed email cannot be null")
    @AssertFalse(message = "Confirmed email must be false")
    private boolean confirmedEmail;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "^\\d+$", message = "Phone number must contain only digits")
    @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

    @NotNull(message = "Confirmed phone number cannot be null")
    @AssertFalse(message = "Confirmed phone number must be false")
    private boolean confirmedPhoneNumber;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{10,}$", message = "Password must be at least 10 characters long and contain at least one digit, one lowercase letter, one uppercase letter, and one special character (@#$%^&+=)")
    private String password;
    
    @NotNull(message = "Date and time must be provided")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}", message = "Invalid date and time format. Use yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String dateBirth;
    
    private IdentificationTypeDTO identificationType;
    
    private AffiliationRegimeDTO affiliationRegime;

    private EpsDTO eps;
    
    @AssertFalse(message = "Account statement must be false")
    private boolean accountStatement;
    
    private RoleDTO role;
    
    public PatientDTO() {
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
        setIdentificationType(new IdentificationTypeDTO());
        setAffiliationRegime(new AffiliationRegimeDTO());
        setEps(new EpsDTO());
        setAccountStatement(false);
        setRole(new RoleDTO());
    }
}

