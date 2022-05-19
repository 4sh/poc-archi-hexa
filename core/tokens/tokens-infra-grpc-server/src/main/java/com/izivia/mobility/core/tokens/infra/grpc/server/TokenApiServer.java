package com.izivia.mobility.core.tokens.infra.grpc.server;

import static com.izivia.mobility.core.tokens.infra.grpc.mapper.TokenGrpcServerMapper.toBusiness;
import static com.izivia.mobility.core.tokens.infra.grpc.mapper.TokenGrpcServerMapper.toProto;

import com.izivia.mobility.core.tokens.api.proto.TokenApiServiceGrpc.TokenApiServiceImplBase;
import com.izivia.mobility.core.tokens.api.proto.Tokens.TokenCreationRequest;
import com.izivia.mobility.core.tokens.api.proto.Tokens.TokenCreationResponse;
import com.izivia.mobility.core.tokens.api.proto.Tokens.TokenDto;
import com.izivia.mobility.core.tokens.api.proto.Tokens.TokenFindAllRequest;
import com.izivia.mobility.core.tokens.api.proto.Tokens.TokenFindUniqueRequest;
import com.izivia.mobility.core.tokens.api.proto.Tokens.TokenFindUniqueResponse;
import com.izivia.mobility.core.tokens.domain.data.Token;
import com.izivia.mobility.core.tokens.domain.ports.api.TokenServicePort;
import com.izivia.mobility.core.tokens.infra.grpc.mapper.TokenGrpcServerMapper;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class TokenApiServer extends TokenApiServiceImplBase {

  private final TokenServicePort service;

  @Override
  public void findUnique(TokenFindUniqueRequest request, StreamObserver<TokenFindUniqueResponse> responseObserver) {
    service.findUnique(request.getUuid()).ifPresent(token -> responseObserver
        .onNext(TokenFindUniqueResponse
            .newBuilder()
            .setToken(toProto(token))
            .build()));
    responseObserver.onCompleted();
  }

  @Override
  public void create(TokenCreationRequest request, StreamObserver<TokenCreationResponse> responseObserver) {
    Token token = toBusiness(request.getToken());
    service.create(token).ifPresent(savedToken -> responseObserver
        .onNext(TokenCreationResponse
            .newBuilder()
            .setToken(toProto(savedToken))
            .build()));
    responseObserver.onCompleted();
  }

  @Override
  public void findAll(TokenFindAllRequest request, StreamObserver<TokenDto> responseObserver) {
    service.findAll()
        .stream()
        .map(TokenGrpcServerMapper::toProto)
        .forEach(responseObserver::onNext);
    responseObserver.onCompleted();
  }
}
