package co.edu.uco.ucobet.generales.apication.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

public class CountryDTO {

	private UUID id;
	private String name;

	public CountryDTO(final UUID id, final String name) {
		setId(id);
		setName(name);
	}

	public static CountryDTO create(final UUID id, final String name) {
		return new CountryDTO(id, name);
	}

	public UUID getId() {
		return id;
	}

	private void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

}
