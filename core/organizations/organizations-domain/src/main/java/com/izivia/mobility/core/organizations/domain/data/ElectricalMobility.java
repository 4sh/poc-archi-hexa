package com.izivia.mobility.core.organizations.domain.data;

public record ElectricalMobility(String id,
                                 String name,
                                 PostalAddress postalAddress,
                                 AuditData auditData,
                                 String tin) {}
