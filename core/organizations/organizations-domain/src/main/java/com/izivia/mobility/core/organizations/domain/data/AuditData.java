package com.izivia.mobility.core.organizations.domain.data;

public record AuditData(AuditDataItem deletion,
                        AuditDataItem update, AuditDataItem creation) {

}

