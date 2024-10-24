package co.edu.uco.ucobet.generales.apication.usecase.state.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uco.ucobet.generales.apication.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.apication.secondaryports.repository.StateRepository;
import co.edu.uco.ucobet.generales.apication.usecase.state.RetrieveState;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Service
public class RetriveStateImpl implements RetrieveState {

	private StateRepository stateRepository;

	public RetriveStateImpl(StateRepository stateRepository) {
		this.stateRepository = stateRepository;
	}

	@Override
	public List<StateDomain> execute(StateDomain domain) {
		var stateEntity = StateEntityMapper.INSTANCE.toEntity(domain);
		var resultadosEntity = stateRepository.findByFilter(stateEntity);
		return StateEntityMapper.INSTANCE.toDomainCollection(resultadosEntity);
	}

}
