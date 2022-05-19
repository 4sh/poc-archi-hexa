package com.izivia.mobility.core.tokens.infra.grpc.mapper;

import com.izivia.mobility.core.tokens.api.proto.Tokens.TokenDto;
import com.izivia.mobility.core.tokens.domain.data.ElectricalMobilityRef;
import com.izivia.mobility.core.tokens.domain.data.Token;
import com.izivia.mobility.core.tokens.domain.data.TokenKind;

public class TokenGrpcServerMapper {

  public static TokenDto toProto(Token token) {
    return TokenDto.newBuilder()
        .setId(token.id())
        .setKind(TokenDto.TokenKind.valueOf(token.kind().name()))
        .setUuid(token.uuid())
        .setProviderRef(token.providerRef().id())
        .build();
  }

  public static Token toBusiness(TokenDto dto) {
    return new Token(dto.getId(),
        dto.getUuid(),
        new ElectricalMobilityRef(dto.getProviderRef(), "ElectricalMobilityServiceProvider"),
        TokenKind.valueOf(dto.getKind().name()));
  }

}
