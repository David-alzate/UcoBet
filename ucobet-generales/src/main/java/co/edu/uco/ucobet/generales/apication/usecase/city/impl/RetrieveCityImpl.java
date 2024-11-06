package co.edu.uco.ucobet.generales.apication.usecase.city.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import co.edu.uco.ucobet.generales.apication.secondaryports.mapper.CityEntityMapper;
import co.edu.uco.ucobet.generales.apication.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.apication.usecase.city.RetrieveCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Service
public class RetrieveCityImpl implements RetrieveCity{
	
	private CityRepository cityRepository;
	
	public RetrieveCityImpl(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}


	@Override
	public List<CityDomain> execute(CityDomain domain) {
		var cityEntity = CityEntityMapper.INSTANCE.toEntity(domain);
		var resultadosEntity = cityRepository.findByFilter(cityEntity);
		return CityEntityMapper.INSTANCE.toDomainCollection(resultadosEntity);
	}

}
