package com.izivia.mobility.core.tokens.infra.db.mongo.adapters;

import static com.izivia.mobility.core.tokens.infra.db.mongo.mappers.TokenEntityMapper.INSTANCE;
import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

import com.izivia.mobility.core.tokens.domain.data.Token;
import com.izivia.mobility.core.tokens.domain.ports.spi.TokenRepositoryPort;
import com.izivia.mobility.core.tokens.infra.db.mongo.entities.TokenEntity;
import com.izivia.mobility.core.tokens.infra.db.mongo.repositories.TokenEntityRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TokenEntityMongoAdapter implements TokenRepositoryPort {

  TokenEntityRepository tokenEntityRepository;

  @Override
  public List<Token> findAll() {
    List<TokenEntity> entities = tokenEntityRepository.findAll();
    return INSTANCE
        .tokenEntitiesToTokens(entities);
  }

  @Override
  public Optional<Token> findUnique(String id) {
    TokenEntity entity = tokenEntityRepository.findByUuid(id)
        .orElseThrow(() -> new RuntimeException(" Token entity not found with uuid: " + id));
    return ofNullable(INSTANCE
        .tokenEntityToToken(entity));
  }

  @Override
  public Optional<Token> create(Token token) {
    TokenEntity entity = INSTANCE
        .tokenToTokenEntity(token);
    return ofNullable(INSTANCE.
        tokenEntityToToken(tokenEntityRepository.save(entity)));
  }
}
