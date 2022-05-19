package com.izivia.mobility.core.tokens.domain.ports.api;

import com.izivia.mobility.core.tokens.domain.data.Token;
import java.util.List;
import java.util.Optional;

public interface TokenServicePort {

  List<Token> findAll();

  Optional<Token> findUnique(String id);

  Optional<Token> create(Token token);
}
