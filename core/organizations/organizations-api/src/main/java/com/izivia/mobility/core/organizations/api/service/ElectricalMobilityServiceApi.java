package com.izivia.mobility.core.organizations.api.service;

import com.izivia.mobility.core.organizations.api.data.ElectricalMobilityApiData;
import java.util.List;
import java.util.Optional;

public interface ElectricalMobilityServiceApi {
 List<ElectricalMobilityApiData> findAll();

 Optional<ElectricalMobilityApiData> findUnique(String id);

 Optional<ElectricalMobilityApiData> create(ElectricalMobilityApiData electricalMobilityApiData);

}
