package co.edu.uco.ucobet.generales.apication.primaryports.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper(componentModel = "spring", imports = { UUID.class })
public interface RegisterNewCityMapper {

	RegisterNewCityMapper INSTANCE = Mappers.getMapper(RegisterNewCityMapper.class);

	@Mapping(source = "cityName", target = "name")
	@Mapping(source = "stateId", target = "state", qualifiedByName = "mapToStateDomain")
	CityDomain toDomain(RegisterNewCityDTO dto);

	@Named("mapToStateDomain")
	default StateDomain mapToStateDomain(UUID stateId) {
		return new StateDomain(stateId, null, null);
	}

}