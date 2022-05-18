package com.izivia.mobility.core.organizations.domain.data;

import java.time.Instant;


public record AuditDataItem(String userLogin, Instant instant) {

}
