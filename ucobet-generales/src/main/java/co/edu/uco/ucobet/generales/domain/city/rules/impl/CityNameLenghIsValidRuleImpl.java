package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameLenghIsNotValidException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameLenghIsValidRule;

@Service
public class CityNameLenghIsValidRuleImpl implements CityNameLenghIsValidRule {

	private static final int MIN_NAME_LENGTH = 3;
	private static final int MAX_NAME_LENGTH = 255;

	@Override
	public void validate(String data) {
		if (data.length() < MIN_NAME_LENGTH || data.length() > MAX_NAME_LENGTH) {
			throw CityNameLenghIsNotValidException.create();
		}

	}

}
