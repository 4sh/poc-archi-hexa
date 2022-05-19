package com.izivia.mobility.core.tokens.infra.db.mongo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "token")
public record TokenEntity(@Id String id,
                          String uuid,
                          ElectricalMobilityRefEntity providerRef,
                          TokenKindEntity kind) {

}