package com.izivia.mobility.core.organizations.infra.db.mongo.entities;

public record PostalAddressEntity(String street,
                            String city,
                            String zipCode,
                            String country) {}
