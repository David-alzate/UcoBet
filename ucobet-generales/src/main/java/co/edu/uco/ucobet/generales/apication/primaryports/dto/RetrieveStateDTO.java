package co.edu.uco.ucobet.generales.apication.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public final class RetrieveStateDTO {

	private UUID id;
	private String name;
	private CountryDTO country;
	
	public RetrieveStateDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setCountry(country);
	}

	public RetrieveStateDTO(final UUID id, final String name, final CountryDTO country) {
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	public static RetrieveStateDTO create() {
		return new RetrieveStateDTO();
	}
	
	public static RetrieveStateDTO create(final UUID id, final String name, final CountryDTO country) {
		return new RetrieveStateDTO(id, name, country);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public final CountryDTO getCountry() {
		return country;
	}

	public final void setCountry(final CountryDTO country) {
		this.country = country;
	}

}
