package com.izivia.mobility.core.organizations.infra.grpc.client.service;

import static com.izivia.mobility.core.organizations.infra.grpc.client.mapper.ElectricalMobilityGrpcClientMapper.toApiData;
import static java.util.Optional.ofNullable;
import static org.apache.commons.collections4.IteratorUtils.toList;

import com.izivia.mobility.core.organizations.api.data.ElectricalMobilityApiData;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityCreationRequest;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityCreationResponse;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityDto;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityFindAllRequest;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityFindUniqueRequest;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityFindUniqueResponse;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobilityApiServiceGrpc.ElectricalMobilityApiServiceBlockingStub;
import com.izivia.mobility.core.organizations.api.service.ElectricalMobilityServiceApi;
import com.izivia.mobility.core.organizations.infra.grpc.client.mapper.ElectricalMobilityGrpcClientMapper;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class ElectricalMobilityApiClient implements ElectricalMobilityServiceApi {

  @GrpcClient("grpc-client-electrical-service")
  private ElectricalMobilityApiServiceBlockingStub synchronousService;


  @Override
  public List<ElectricalMobilityApiData> findAll() {
    ElectricalMobilityFindAllRequest request = ElectricalMobilityFindAllRequest
        .newBuilder()
        .build();

    Iterator<ElectricalMobilityDto> response = synchronousService.findAll(request);
    return toList(response)
        .stream()
        .map(ElectricalMobilityGrpcClientMapper::toApiData)
        .toList();
  }

  @Override
  public Optional<ElectricalMobilityApiData> findUnique(String id) {
    ElectricalMobilityFindUniqueRequest request = ElectricalMobilityFindUniqueRequest
        .newBuilder()
        .setId(id)
        .build();

    ElectricalMobilityFindUniqueResponse response = synchronousService.findUnique(request);
    return ofNullable(toApiData(response.getElectricalMobility()));
  }

  @Override
  public Optional<ElectricalMobilityApiData> create(ElectricalMobilityApiData electricalMobilityApiData) {
    ElectricalMobilityCreationRequest request = ElectricalMobilityCreationRequest
        .newBuilder()
        .setElectricalMobility(ElectricalMobilityGrpcClientMapper.toProto(electricalMobilityApiData))
        .build();

    ElectricalMobilityCreationResponse response = synchronousService.create(request);
    return ofNullable(toApiData(response.getElectricalMobility()));
  }
}
