package co.edu.uco.ucobet.generales.apication.secondaryports.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import co.edu.uco.ucobet.generales.apication.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

@Mapper(componentModel = "spring")
public interface CityEntityMapper {

    CityEntityMapper INSTANCE = Mappers.getMapper(CityEntityMapper.class);

    @Mapping(source = "name", target = "name")
    CityEntity toEntity(CityDomain domain);
    
}