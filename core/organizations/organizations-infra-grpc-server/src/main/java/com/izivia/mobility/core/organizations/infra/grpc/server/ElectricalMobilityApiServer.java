package com.izivia.mobility.core.organizations.infra.grpc.server;

import static com.izivia.mobility.core.organizations.infra.grpc.mapper.ElectricalMobilityGrpcServerMapper.toBusiness;
import static com.izivia.mobility.core.organizations.infra.grpc.mapper.ElectricalMobilityGrpcServerMapper.toProto;

import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityCreationRequest;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityCreationResponse;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityDto;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityFindAllRequest;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityFindUniqueRequest;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityFindUniqueResponse;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobilityApiServiceGrpc.ElectricalMobilityApiServiceImplBase;
import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import com.izivia.mobility.core.organizations.domain.ports.api.ElectricalMobilityServicePort;
import com.izivia.mobility.core.organizations.infra.grpc.mapper.ElectricalMobilityGrpcServerMapper;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class ElectricalMobilityApiServer extends ElectricalMobilityApiServiceImplBase {

  private final ElectricalMobilityServicePort service;

  @Override
  public void findAll(ElectricalMobilityFindAllRequest request,
      StreamObserver<ElectricalMobilityDto> responseObserver) {
    service.findAll()
        .stream()
        .map(ElectricalMobilityGrpcServerMapper::toProto)
        .forEach(responseObserver::onNext);
    responseObserver.onCompleted();
  }

  @Override
  public void findUnique(ElectricalMobilityFindUniqueRequest request,
      StreamObserver<ElectricalMobilityFindUniqueResponse> responseObserver) {
    service.findUnique(request.getId()).ifPresent(electricalMobility -> responseObserver
        .onNext(ElectricalMobilityFindUniqueResponse
            .newBuilder()
            .setElectricalMobility(toProto(electricalMobility))
            .build()));
    responseObserver.onCompleted();
  }

  @Override
  public void create(ElectricalMobilityCreationRequest request,
      StreamObserver<ElectricalMobilityCreationResponse> responseObserver) {
    ElectricalMobility electricalMobility = toBusiness(request.getElectricalMobility());
    service.create(electricalMobility).ifPresent(savedElectricalMobility -> responseObserver
        .onNext(ElectricalMobilityCreationResponse
            .newBuilder()
            .setElectricalMobility(toProto(savedElectricalMobility))
            .build()));
    responseObserver.onCompleted();
  }
}
