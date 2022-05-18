package com.izivia.mobility.core.organizations.domain.ports.spi;

import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import java.util.List;

public interface ElectricalMobilityRepositoryPort {

  List<ElectricalMobility> findAll();

  ElectricalMobility findUnique(String id);

  ElectricalMobility create(ElectricalMobility electricalMobility);

}
