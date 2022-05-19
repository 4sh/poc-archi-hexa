package com.izivia.mobility.core.tokens.infra.db.mongo.mappers;

import com.izivia.mobility.core.tokens.domain.data.Token;
import com.izivia.mobility.core.tokens.infra.db.mongo.entities.TokenEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TokenEntityMapper {

  TokenEntityMapper INSTANCE = Mappers.getMapper(TokenEntityMapper.class);

  Token tokenEntityToToken(TokenEntity tokenEntity);

  TokenEntity tokenToTokenEntity(Token token);

  List<Token> tokenEntitiesToTokens(List<TokenEntity> tokenEntities);

  List<TokenEntity> tokensToTokenEntities(List<Token> tokens);

}
