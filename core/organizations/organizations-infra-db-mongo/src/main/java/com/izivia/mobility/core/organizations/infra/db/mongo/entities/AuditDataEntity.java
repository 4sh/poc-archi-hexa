package com.izivia.mobility.core.organizations.infra.db.mongo.entities;

public record AuditDataEntity(AuditDataItemEntity deletion,
                              AuditDataItemEntity update, AuditDataItemEntity creation) {

}


