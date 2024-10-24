package co.edu.uco.ucobet.generales.apication.primaryports.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.apication.primaryports.dto.RetrieveStateDTO;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

@Mapper(componentModel = "spring")
public interface RetrieveStateMapper {

	RetrieveStateMapper INSTANCE = Mappers.getMapper(RetrieveStateMapper.class);

	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "country", target = "country")
	StateDomain toDomain(RetrieveStateDTO dto);

	// Método de mapeo adicional
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "country", target = "country")
	RetrieveStateDTO toDto(StateDomain stateDomain);

	List<RetrieveStateDTO> toDtoCollection(List<StateDomain> domains);

}
