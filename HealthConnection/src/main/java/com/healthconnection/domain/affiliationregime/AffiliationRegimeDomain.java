package com.healthconnection.domain.affiliationregime;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.healthconnection.crosscutting.helper.ObjectHelper;
import com.healthconnection.crosscutting.helper.TextHelper;
import com.healthconnection.crosscutting.helper.UuidHelper;

@Service
public class AffiliationRegimeDomain {
	
	private UUID id;

	private String type;

	private String serviceCoverages;
	
	public AffiliationRegimeDomain() {
		setId(UuidHelper.DEFAULT_UUID);
		setType(TextHelper.EMPTY);
		setServiceCoverages(TextHelper.EMPTY);
	}

	public AffiliationRegimeDomain(final UUID id, final String type, final String serviceCoverages) {
		setId(id);
		setType(type);
		setServiceCoverages(serviceCoverages);
	}
	
	public static final AffiliationRegimeDomain crear(final UUID id, final String type, final String serviceCoverages) {
		return new AffiliationRegimeDomain(id, type, serviceCoverages);
	}
	
	public static final AffiliationRegimeDomain crear() {
		return new AffiliationRegimeDomain();
	}

	public final UUID getId() {
		return id;
	}

	public final String getType() {
		return type;
	}

	public final String getServiceCoverages() {
		return serviceCoverages;
	}

	public final void setId(UUID id) {
		this.id = ObjectHelper.getDefault(id, UuidHelper.DEFAULT_UUID);
	}

	public final void setType(String type) {
		this.type = ObjectHelper.getDefault(type, TextHelper.EMPTY);
	}

	public final void setServiceCoverages(String serviceCoverages) {
		this.serviceCoverages = ObjectHelper.getDefault(serviceCoverages, TextHelper.EMPTY);
	}
	
	

}
