package com.izivia.mobility.core.organizations.app.config;

import static lombok.AccessLevel.PRIVATE;

import com.izivia.mobility.core.organizations.domain.ports.api.ElectricalMobilityServicePort;
import com.izivia.mobility.core.organizations.domain.services.ElectricalMobilityServiceImpl;
import com.izivia.mobility.core.organizations.infra.db.mongo.adapters.ElectricalMobilityEntityMongoAdapter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrganizationsAppConfig {

  ElectricalMobilityEntityMongoAdapter electricalMobilityEntityMongoAdapter;

  @Bean
  public ElectricalMobilityServicePort electricalMobilityServicePort() {
    return new ElectricalMobilityServiceImpl(electricalMobilityEntityMongoAdapter);
  }
}
