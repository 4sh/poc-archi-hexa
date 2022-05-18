package com.izivia.mobility.core.organizations.infra.db.mongo.adapters;

import static com.izivia.mobility.core.organizations.infra.db.mongo.mappers.ElectricalMobilityMapper.INSTANCE;
import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import com.izivia.mobility.core.organizations.domain.ports.spi.ElectricalMobilityRepositoryPort;
import com.izivia.mobility.core.organizations.infra.db.mongo.entities.ElectricalMobilityEntity;
import com.izivia.mobility.core.organizations.infra.db.mongo.repositories.ElectricalMobilityEntityRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ElectricalMobilityEntityMongoAdapter implements ElectricalMobilityRepositoryPort {

  ElectricalMobilityEntityRepository electricalMobilityEntityRepository;

  @Override
  public List<ElectricalMobility> findAll() {
    List<ElectricalMobilityEntity> entities = electricalMobilityEntityRepository.findAll();
    return INSTANCE
        .electricalMobilityEntitiesToElectricalMobilities(entities);
  }

  @Override
  public Optional<ElectricalMobility> findUnique(String id) {
    ElectricalMobilityEntity entity = electricalMobilityEntityRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException(" electricalMobility not found"));
    return ofNullable(INSTANCE
        .electricalMobilityEntityToElectricalMobility(entity));
  }

  @Override
  public Optional<ElectricalMobility> create(ElectricalMobility electricalMobility) {
    ElectricalMobilityEntity entity = INSTANCE
        .electricalMobilityToElectricalMobilityEntity(electricalMobility);
    return ofNullable(INSTANCE.
        electricalMobilityEntityToElectricalMobility(electricalMobilityEntityRepository.save(entity)));
  }
}
