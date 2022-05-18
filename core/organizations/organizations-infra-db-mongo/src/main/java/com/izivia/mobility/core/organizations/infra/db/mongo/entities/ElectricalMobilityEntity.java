package com.izivia.mobility.core.organizations.infra.db.mongo.entities;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "electricalMobilityServiceProvider")
public record ElectricalMobilityEntity(String id,
                                       String name,
                                       PostalAddressEntity postalAddress,
                                       AuditDataEntity auditData,
                                       String tin) {}



