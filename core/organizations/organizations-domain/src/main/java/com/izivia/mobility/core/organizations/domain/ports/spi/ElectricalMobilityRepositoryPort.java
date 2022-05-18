package com.izivia.mobility.core.organizations.domain.ports.spi;

import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import java.util.List;
import java.util.Optional;

public interface ElectricalMobilityRepositoryPort {

  List<ElectricalMobility> findAll();

  Optional<ElectricalMobility> findUnique(String id);

  Optional<ElectricalMobility> create(ElectricalMobility electricalMobility);

}
