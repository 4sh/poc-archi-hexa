package com.izivia.mobility.core.organizations.domain.services;

import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import com.izivia.mobility.core.organizations.domain.ports.api.ElectricalMobilityServicePort;
import com.izivia.mobility.core.organizations.domain.ports.spi.ElectricalMobilityRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ElectricalMobilityServiceImpl implements ElectricalMobilityServicePort {

  ElectricalMobilityRepositoryPort electricalMobilityRepositoryPort;


  @Override
  public List<ElectricalMobility> findAll() {
    return electricalMobilityRepositoryPort.findAll();
  }

  @Override
  public Optional<ElectricalMobility> findUnique(@NonNull String id) {
    return electricalMobilityRepositoryPort.findUnique(id);
  }

  @Override
  public Optional<ElectricalMobility> create(@NonNull ElectricalMobility electricalMobility) {
    return electricalMobilityRepositoryPort.create(electricalMobility);
  }
}
