package co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveCityDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.city.RetrieveCityInteractor;
import co.edu.uco.ucobet.generales.apication.primaryports.mapper.RetrieveCityDTOMapper;
import co.edu.uco.ucobet.generales.apication.usecase.city.RetrieveCity;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RetrieveCityInteractorImpl implements RetrieveCityInteractor {

	private RetrieveCity retrieveCity;

	public RetrieveCityInteractorImpl(RetrieveCity retrieveCity) {
		super();
		this.retrieveCity = retrieveCity;
	}

	@Override
	public List<RetrieveCityDTO> execute(RetrieveCityDTO data) {
		var cityDomain = RetrieveCityDTOMapper.INSTANCE.toDomain(data);
		var resultados = retrieveCity.execute(cityDomain);
		return RetrieveCityDTOMapper.INSTANCE.toDtoCollection(resultados);
	}

}
