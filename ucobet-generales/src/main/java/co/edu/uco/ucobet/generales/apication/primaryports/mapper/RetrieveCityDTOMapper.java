package co.edu.uco.ucobet.generales.apication.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveCityDTO;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Mapper(componentModel = "spring")
public interface RetrieveCityDTOMapper {
	
	RetrieveCityDTOMapper INSTANCE = Mappers.getMapper(RetrieveCityDTOMapper.class);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "state", target = "state")
	CityDomain toDomain(RetrieveCityDTO dto);
	
	// Método de mapeo adicional
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "state", target = "state")
	RetrieveCityDTO toDto(CityDomain stateDomain);

	List<RetrieveCityDTO> toDtoCollection(List<CityDomain> domains);

}
