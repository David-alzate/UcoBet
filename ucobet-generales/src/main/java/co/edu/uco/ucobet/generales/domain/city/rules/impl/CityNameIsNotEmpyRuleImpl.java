package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameIsEmpyExcpetion;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameIsNotEmpyRule;

@Service
public class CityNameIsNotEmpyRuleImpl implements CityNameIsNotEmpyRule {

	@Override
	public void validate(String data) {
		if (TextHelper.isEmpty(data)) {
			throw CityNameIsEmpyExcpetion.create();
		}

	}

}
