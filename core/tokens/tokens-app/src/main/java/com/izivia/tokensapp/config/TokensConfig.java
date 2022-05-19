package com.izivia.tokensapp.config;

import static lombok.AccessLevel.PRIVATE;

import com.izivia.mobility.core.tokens.domain.ports.api.TokenServicePort;
import com.izivia.mobility.core.tokens.domain.services.TokenServiceImpl;
import com.izivia.mobility.core.tokens.infra.db.mongo.adapters.TokenEntityMongoAdapter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TokensConfig {

  TokenEntityMongoAdapter tokenEntityMongoAdapter;

  @Bean
  public TokenServicePort tokenServicePort() {
    return new TokenServiceImpl(tokenEntityMongoAdapter);
  }

}
