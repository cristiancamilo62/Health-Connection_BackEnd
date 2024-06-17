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
public class IdentificationTypeDTO {

	@NotNull
	private UUID id;

	@NotNull
	@NotEmpty
	@Size(min = 2, max = 4)
	private String code;

	@NotNull
	@NotEmpty
	@Size(min = 5, max = 30)
	private String name;
	
	public IdentificationTypeDTO() {
        setId(UuidHelper.DEFAULT_UUID);
        setCode(TextHelper.EMPTY);
        setName(TextHelper.EMPTY);
        
	}
}
