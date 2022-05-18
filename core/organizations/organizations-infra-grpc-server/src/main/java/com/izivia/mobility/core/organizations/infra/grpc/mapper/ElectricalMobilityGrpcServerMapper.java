package com.izivia.mobility.core.organizations.infra.grpc.mapper;

import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.ElectricalMobilityDto;
import com.izivia.mobility.core.organizations.api.proto.ElectricalMobility.PostalAddressDto;
import com.izivia.mobility.core.organizations.domain.data.ElectricalMobility;
import com.izivia.mobility.core.organizations.domain.data.PostalAddress;

public class ElectricalMobilityGrpcServerMapper {

  public static ElectricalMobilityDto toProto(ElectricalMobility electricalMobility) {
    return ElectricalMobilityDto.newBuilder()
        .setId(electricalMobility.id())
        .setName(electricalMobility.name())
        .setTin(electricalMobility.tin())
        .setPostalAddress(toProto(electricalMobility.postalAddress()))
        .build();
  }

  public static PostalAddressDto toProto(PostalAddress postalAddress) {
    return PostalAddressDto.newBuilder()
        .setCity(postalAddress.city())
        .setCountry(postalAddress.country())
        .setStreet(postalAddress.street())
        .setZipCode(postalAddress.zipCode())
        .build();
  }

  public static ElectricalMobility toBusiness(ElectricalMobilityDto dto) {
    return new ElectricalMobility(dto.getId(),
        dto.getName(),
        toBusiness(dto.getPostalAddress()),
        null,
        dto.getTin());
  }

  public static PostalAddress toBusiness(PostalAddressDto dto) {
    return new PostalAddress(dto.getStreet(),
        dto.getCity(),
        dto.getZipCode(),
        dto.getCountry());
  }

}
