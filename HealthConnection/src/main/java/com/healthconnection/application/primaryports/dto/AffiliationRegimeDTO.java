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
@Getter
@Setter
@AllArgsConstructor
public final class AffiliationRegimeDTO {

	@NotNull
	private UUID id;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 15)
	private String type;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 30)
	private String serviceCoverages;

	public AffiliationRegimeDTO() {
		setId(UuidHelper.DEFAULT_UUID);
		setType(TextHelper.EMPTY);
		setServiceCoverages(TextHelper.EMPTY);
	}

}
