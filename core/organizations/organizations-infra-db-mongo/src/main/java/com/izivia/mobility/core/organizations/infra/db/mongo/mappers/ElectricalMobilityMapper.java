package com.izivia.mobility.core.organizations.infra.db.mongo.mappers;


import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import com.izivia.mobility.core.organizations.infra.db.mongo.entities.ElectricalMobilityEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ElectricalMobilityMapper {

  ElectricalMobilityMapper INSTANCE = Mappers.getMapper(ElectricalMobilityMapper.class);

  ElectricalMobility electricalMobilityEntityToElectricalMobility(ElectricalMobilityEntity electricalMobilityEntity);

  ElectricalMobilityEntity electricalMobilityToElectricalMobilityEntity(ElectricalMobility electricalMobility);


  List<ElectricalMobility> electricalMobilityEntitiesToElectricalMobilities(
      List<ElectricalMobilityEntity> electricalMobilityEntities);

  List<ElectricalMobilityEntity> ElectricalMobilitiesToElectricalMobilityEntities(
      List<ElectricalMobility> electricalMobilities);

}
