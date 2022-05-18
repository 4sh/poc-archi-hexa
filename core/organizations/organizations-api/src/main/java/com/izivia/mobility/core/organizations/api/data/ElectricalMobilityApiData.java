package com.izivia.mobility.core.organizations.api.data;

import static lombok.AccessLevel.PRIVATE;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@ToString
@FieldDefaults(level = PRIVATE)
public class ElectricalMobilityApiData {

  String id;
  String name;
  PostalAddressApiData postalAddress;
  String tin;
}

