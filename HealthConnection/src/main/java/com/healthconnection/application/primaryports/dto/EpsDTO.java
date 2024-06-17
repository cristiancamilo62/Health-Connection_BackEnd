package com.healthconnection.application.primaryports.dto;

import java.util.UUID;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@AllArgsConstructor
public class EpsDTO {
	
	@NotNull
	private UUID id;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 15)
	private String name;
	
	public EpsDTO() {
		setId(UuidHelper.DEFAULT_UUID);
		setName(TextHelper.EMPTY);
		
	}
	
	

	
	
}
