package com.izivia.mobility.core.tokens.domain.ports.spi;

import com.izivia.mobility.core.tokens.domain.data.Token;
import java.util.List;
import java.util.Optional;

public interface TokenRepositoryPort {

  List<Token> findAll();

  Optional<Token> findUnique(String id);

  Optional<Token> create(Token token);

}
