package com.izivia.mobility.core.tokens.domain.services;

import com.izivia.mobility.core.organizations.api.service.ElectricalMobilityServiceApi;
import com.izivia.mobility.core.tokens.domain.data.Token;
import com.izivia.mobility.core.tokens.domain.ports.api.TokenServicePort;
import com.izivia.mobility.core.tokens.domain.ports.spi.TokenRepositoryPort;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TokenServiceImpl implements TokenServicePort {

  TokenRepositoryPort tokenRepositoryPort;
  ElectricalMobilityServiceApi electricalMobilityServiceApi;

  @Override
  public List<Token> findAll() {
    return tokenRepositoryPort.findAll();
  }

  @Override
  public Optional<Token> findUnique(String id) {
    return tokenRepositoryPort.findUnique(id);
  }

  @Override
  public Optional<Token> create(Token token) {
    checkTokenParameters(token);
    return tokenRepositoryPort.create(token);
  }

  private void checkTokenParameters(Token token) {
    electricalMobilityServiceApi.findUnique(token.providerRef().id());
/*
    try {
      electricalMobilityServiceApi.findUnique(token.providerRef().id());
    } catch (Exception e) {
      throw new DomainException(ErrorType.NOT_FOUND, e.getMessage());
    }*/
  }
}
