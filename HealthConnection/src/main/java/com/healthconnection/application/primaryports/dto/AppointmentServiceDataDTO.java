package com.healthconnection.application.primaryports.dto;

import java.util.UUID;
import com.healthconnection.crosscutting.helper.LongHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@AllArgsConstructor
public class AppointmentServiceDataDTO {

	private UUID code;

	private String clinic;
	
	private long price;

	public AppointmentServiceDataDTO() {
		setCode(UuidHelper.DEFAULT_UUID);
		setClinic(TextHelper.EMPTY);
		setPrice(LongHelper.DEFAULT_LONG);
	}
	
}