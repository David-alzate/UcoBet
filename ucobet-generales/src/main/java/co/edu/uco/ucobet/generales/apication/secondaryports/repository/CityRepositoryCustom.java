package co.edu.uco.ucobet.generales.apication.secondaryports.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;

@Repository
public interface CityRepositoryCustom {
	
	List<CityEntity> findByFilter(CityEntity filter);

}
