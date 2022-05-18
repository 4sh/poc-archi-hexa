package com.izivia.mobility.core.organizations.domain.ports.api;

import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import java.util.List;


public interface ElectricalMobilityServicePort {

  List<ElectricalMobility> findAll();

  ElectricalMobility findUnique(String id);

  ElectricalMobility create(ElectricalMobility electricalMobility);

}
