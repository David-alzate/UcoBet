package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import java.util.UUID;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNullRule;

public final class CityIdIsNotNullRuleImpl implements CityIdIsNullRule{

	@Override
	public void validate(final UUID data) {
		if(ObjectHelper.isNull(data)) {
//			throw Exception
		}
		
	}

}
