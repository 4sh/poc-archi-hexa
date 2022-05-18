package com.izivia.mobility.core.organizations.infra.db.mongo.entities;

import java.time.Instant;

public record AuditDataItemEntity(String userLogin, Instant instant) {}


