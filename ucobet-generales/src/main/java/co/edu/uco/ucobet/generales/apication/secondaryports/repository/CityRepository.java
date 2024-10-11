package co.edu.uco.ucobet.generales.apication.secondaryports.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, UUID>, CityRepositoryCustom{

}
