package com.izivia.mobility.core.tokens.domain.data;

public record Token(String id,
                    String uuid,
                    ElectricalMobilityRef providerRef,
                    TokenKind kind) {}