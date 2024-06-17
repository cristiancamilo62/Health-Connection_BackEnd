package com.healthconnection.domain.appointmentservicedata;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.helper.LongHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;

@Service
public class AppointmentServiceDataDomain {
	
	private UUID code;

	private String clinic;
	
	private long price;
	
	public AppointmentServiceDataDomain() {
		setCode(UuidHelper.DEFAULT_UUID);
		setClinic(TextHelper.EMPTY);
		setPrice(LongHelper.DEFAULT_LONG);
	}
	

	public AppointmentServiceDataDomain(UUID code, String clinic, long price) {
		setCode(code);
		setClinic(clinic);
		setPrice(price);
	}


	public final String getClinic() {
		return clinic;
	}


	public final void setClinic(String clinic) {
		this.clinic = clinic;
	}


	public final long getPrice() {
		return price;
	}


	public final void setPrice(long price) {
		this.price = price;
	}


	public final void setCode(UUID code) {
		this.code = code;
	}


	public final UUID getCode() {
		return code;
	}
	

}
