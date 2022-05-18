package com.izivia.mobility.core.organizations.infra.grpc.client.mapper;

import com.izivia.mobility.core.organizations.api.data.ElectricalMobilityApiData;
import com.izivia.mobility.core.organizations.api.data.PostalAddressApiData;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityDto;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.PostalAddressDto;

public class ElectricalMobilityGrpcClientMapper {

  public static ElectricalMobilityApiData toApiData(ElectricalMobilityDto dto) {
    return ElectricalMobilityApiData.builder()
        .id(dto.getId())
        .name(dto.getName())
        .postalAddress(toApiData(dto.getPostalAddress()))
        .tin(dto.getTin())
        .build();

  }

  public static PostalAddressApiData toApiData(PostalAddressDto dto) {
    return PostalAddressApiData.builder()
        .street(dto.getStreet())
        .city(dto.getCity())
        .zipCode(dto.getZipCode())
        .country(dto.getCountry())
        .build();
  }

  public static ElectricalMobilityDto toProto(ElectricalMobilityApiData data) {
    return ElectricalMobilityDto.newBuilder()
        .setId(data.getId())
        .setName(data.getName())
        .setPostalAddress(toProto(data.getPostalAddress()))
        .setTin(data.getTin())
        .build();
  }

  public static PostalAddressDto toProto(PostalAddressApiData data) {
    return PostalAddressDto.newBuilder()
        .setStreet(data.getStreet())
        .setZipCode(data.getZipCode())
        .setCity(data.getCity())
        .setCountry(data.getCountry())
        .build();
  }
}
