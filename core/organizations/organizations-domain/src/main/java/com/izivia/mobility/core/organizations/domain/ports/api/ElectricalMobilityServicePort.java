package com.izivia.mobility.core.organizations.domain.ports.api;

import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import com.izivia.mobility.core.organizations.domain.error.DomainException;
import java.util.List;
import java.util.Optional;


public interface ElectricalMobilityServicePort {

  List<ElectricalMobility> findAll();

  Optional<ElectricalMobility> findUnique(String id) throws DomainException;

  Optional<ElectricalMobility> create(ElectricalMobility electricalMobility);

}
