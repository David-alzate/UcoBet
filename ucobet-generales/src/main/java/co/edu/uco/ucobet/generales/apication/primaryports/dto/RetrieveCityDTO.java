package co.edu.uco.ucobet.generales.apication.primaryports.dto;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

public final class RetrieveCityDTO {

	private UUID id;
	private String name;
	private StateDomain state;
	
	public RetrieveCityDTO() {
		setId(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
		setState(state);
	}

	public RetrieveCityDTO(UUID id, String name, StateDomain state) {
		setId(id);
		setName(name);
		setState(state);
	}
	
	public static RetrieveCityDTO create(UUID id, String name, StateDomain state) {
		return new RetrieveCityDTO(id, name, state);
	}
	
	public static RetrieveCityDTO create() {
		return new RetrieveCityDTO();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = TextHelper.applyTrim(name);
	}

	public StateDomain getState() {
		return state;
	}

	public void setState(StateDomain state) {
		this.state = state;
	}

}
