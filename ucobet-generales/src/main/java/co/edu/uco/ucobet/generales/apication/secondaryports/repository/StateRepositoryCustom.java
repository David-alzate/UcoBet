package co.edu.uco.ucobet.generales.apication.secondaryports.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.StateEntity;

@Repository
public interface StateRepositoryCustom {
	
	List<StateEntity> findByFilter(StateEntity filter);

}
