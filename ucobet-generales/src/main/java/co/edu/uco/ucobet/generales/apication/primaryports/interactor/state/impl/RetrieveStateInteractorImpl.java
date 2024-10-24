package co.edu.uco.ucobet.generales.apication.primaryports.interactor.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.apication.primaryports.interactor.state.RetrieveStateInteractor;
import co.edu.uco.ucobet.generales.apication.primaryports.mapper.RetrieveStateMapper;
import co.edu.uco.ucobet.generales.apication.usecase.state.RetrieveState;

@Service
@Transactional
public class RetrieveStateInteractorImpl implements RetrieveStateInteractor{
	
	private RetrieveState retrieveState;
	
	public RetrieveStateInteractorImpl(RetrieveState retrieveState) {
		this.retrieveState = retrieveState;
	}

	@Override
	public List<RetrieveStateDTO> execute(RetrieveStateDTO data) {
		var stateDomain = RetrieveStateMapper.INSTANCE.toDomain(data);
		var resultados = retrieveState.execute(stateDomain);
		return RetrieveStateMapper.INSTANCE.toDtoCollection(resultados);
	}

}
