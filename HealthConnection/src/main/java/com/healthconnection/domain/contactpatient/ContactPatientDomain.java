package com.healthconnection.domain.contactpatient;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;

@Service
public class ContactPatientDomain {
	
	private UUID id;

	private String email;

	private boolean confirmedEmail;

	private String phoneNumber;

	private boolean confirmedPhoneNumber;

	private String password;
	
	

	public ContactPatientDomain() {
		setId(UuidHelper.DEFAULT_UUID);
		setEmail(TextHelper.EMPTY);
		setConfirmedEmail(false);
		setPhoneNumber(TextHelper.EMPTY);
		setConfirmedPhoneNumber(false);
		setPassword(TextHelper.EMPTY);
	}

	public ContactPatientDomain(final UUID id, final String email, final boolean confirmedEmail, final String phoneNumber,
			final boolean confirmedPhoneNumber, final String password) {
		setId(id);
		setEmail(email);
		setConfirmedEmail(confirmedEmail);
		setPhoneNumber(phoneNumber);
		setConfirmedPhoneNumber(confirmedPhoneNumber);
		setPassword(password);
	}

	public static final ContactPatientDomain crear(final UUID id, final String email, final boolean confirmedEmail, final String phoneNumber,
			final boolean confirmedPhoneNumber, final String password) {
		return new ContactPatientDomain(id, email, confirmedEmail, phoneNumber, confirmedPhoneNumber, password);
	}
	
	public static final ContactPatientDomain crear() {
		return new ContactPatientDomain();
	}


	public final UUID getId() {
		return id;
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

	public final void setId(UUID id) {
		this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
	}

	public final void setEmail(String email) {
		this.email = ObjectHelper.getDefault(email, TextHelper.EMPTY);
	}

	public final void setConfirmedEmail(boolean confirmedEmail) {
		this.confirmedEmail = ObjectHelper.getDefault(confirmedEmail, false);
	}

	public final void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = ObjectHelper.getDefault(phoneNumber, TextHelper.EMPTY);
	}

	public final void setConfirmedPhoneNumber(boolean confirmedPhoneNumber) {
		this.confirmedPhoneNumber = ObjectHelper.getDefault(confirmedPhoneNumber, false);
	}

	public final void setPassword(String password) {
		this.password = ObjectHelper.getDefault(password, TextHelper.EMPTY);
	}
	
	

}